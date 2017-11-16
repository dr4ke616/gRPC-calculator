package server

import java.util.logging.Logger
import javax.script.ScriptEngineManager

import grpctest.proto.calculator.{CalculatorGrpc, ExpressionAnswer, ExpressionRequest}
import io.grpc.{Server, ServerBuilder}

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

  private[this] var _server: Server = _

  private[server] def start(): Unit = {
    _server = ServerBuilder
      .forPort(port)
      .addService(CalculatorGrpc.bindService(new CalculatorImpl(), ex))
      .build
      .start

    log.info(s"Starting Calculator server on $port...")

    sys.addShutdownHook {
      log.info(s"Shutting down Calculator server...")
      self.stop()
    }
  }

  private def stop(): Unit = if (_server != null) {
    _server.shutdown()
  }

  def blockUntilShutdown(): Unit = if (_server != null) {
    _server.awaitTermination()
  }

  private class CalculatorImpl extends CalculatorGrpc.Calculator {

    private val jsEngine =
      new ScriptEngineManager()
        .getEngineByMimeType("text/javascript")

    override def evaluate(request: ExpressionRequest): Future[ExpressionAnswer] =
      Future.successful {
        log.info("Handling incoming evaluation request")
        ExpressionAnswer(jsEngine.eval(request.expr).toString)
      }
  }
}
