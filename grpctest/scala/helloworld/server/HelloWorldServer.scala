package helloworld.server

import java.util.logging.Logger

import grpctest.proto.hw.helloworld.{GreeterGrpc, HelloReply, HelloRequest}
import io.grpc.{Server, ServerBuilder}

import scala.concurrent.{ExecutionContext, Future}


object HelloWorldServer {

  private implicit val log: Logger =
    Logger.getLogger(classOf[HelloWorldServer].getName)

  def start(port: Int)(implicit ex: ExecutionContext): HelloWorldServer = {
    val server = new HelloWorldServer(port)
    server.start()
    server
  }
}

private[server] class HelloWorldServer(port: Int)(implicit ex: ExecutionContext, log: Logger) {
  self ⇒

  private[this] var _server: Server = _

  private[server] def start(): Unit = {
    _server = ServerBuilder
      .forPort(port)
      .addService(GreeterGrpc.bindService(new GreeterImpl(), ex))
      .build
      .start

    log.info(s"Starting HelloWorld server on port $port...")

    sys.addShutdownHook {
      log.info(s"Shutting down HelloWorld server...")
      self.stop()
    }
  }

  private def stop(): Unit = if (_server != null) {
    _server.shutdown()
  }

  def blockUntilShutdown(): Unit = if (_server != null) {
    _server.awaitTermination()
  }

  private class GreeterImpl extends GreeterGrpc.Greeter {

    override def sayHello(request: HelloRequest): Future[HelloReply] = Future.successful {
      log.info("Handling incoming request on sayHello")
      HelloReply(s"Hello ${request.name}")
    }

  }
}
