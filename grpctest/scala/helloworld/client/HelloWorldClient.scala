package helloworld.client

import java.util.logging.Logger

import grpctest.proto.hw.helloworld.GreeterGrpc.GreeterStub
import grpctest.proto.hw.helloworld.{GreeterGrpc, HelloReply, HelloRequest}
import io.grpc.{ManagedChannel, ManagedChannelBuilder}

import scala.concurrent.{ExecutionContext, Future}


object HelloWorldClient {

  def apply(host: String, port: Int)(implicit ex: ExecutionContext): HelloWorldClient = {
    val channel = ManagedChannelBuilder
      .forAddress(host, port)
      .usePlaintext(true)
      .build

    val stub = GreeterGrpc.stub(channel)
    new HelloWorldClient(channel, stub)
  }

}

private[client] class HelloWorldClient private(
  private val channel: ManagedChannel,
  private val greeter: GreeterStub)
  (implicit ex: ExecutionContext) {

  private val log: Logger =
    Logger.getLogger(classOf[HelloWorldClient].getName)

  def greet(name: String): Future[HelloReply] = {
    log.info(s"About to say hello to $name")
    val request = HelloRequest(name)

    val fut = greeter.sayHello(request)
    fut.onSuccess { case message: HelloReply ⇒ log.info(s"Get reply: $message") }
    fut
  }

}