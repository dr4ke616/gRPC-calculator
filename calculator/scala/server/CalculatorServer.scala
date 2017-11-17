package server

import java.util.logging.Logger
import javax.script.ScriptEngineManager

import io.grpc.{Server, ServerBuilder}
import protogen.calculator.{CalculatorGrpc, ExpressionAnswer, ExpressionRequest}

import scala.concurrent.{ExecutionContext, Future}


object CalculatorServer {

  private implicit val log: Logger =
    Logger.getLogger(classOf[CalculatorServer].getName)

  def start(port: Int)(implicit ex: ExecutionContext): CalculatorServer = {
    val server = new CalculatorServer(port)
    server.start()
    server
  }
}

private[server] class CalculatorServer(port: Int)(implicit ex: ExecutionContext, log: Logger) {
  self ⇒

  private def server: Server =
    ServerBuilder
      .forPort(port)
      .addService(CalculatorGrpc.bindService(new CalculatorImpl(), ex))
      .build

  private var proc: Option[Server] = None

  private[server] def start(): Unit = {

    log.info(s"Starting Calculator server on $port...")
    proc = Some(server.start())

    sys.addShutdownHook {
      log.info(s"Shutting down Calculator server...")
      self.stop()
    }
  }

  private def stop(): Unit =
    proc.fold()(_.shutdown)

  def blockUntilShutdown(): Unit =
    proc.fold()(_.awaitTermination)
}

private[server] class CalculatorImpl()(implicit log: Logger) extends CalculatorGrpc.Calculator {

  private val jsEngine =
    new ScriptEngineManager()
      .getEngineByMimeType("text/javascript")

  override def evaluate(request: ExpressionRequest): Future[ExpressionAnswer] =
    Future.successful {
      log.info("Handling incoming evaluation request")
      ExpressionAnswer(jsEngine.eval(request.expr).toString)
    }
}
