package client

import grpctest.proto.calculator.CalculatorGrpc.CalculatorStub
import grpctest.proto.calculator.{CalculatorGrpc, ExpressionRequest}
import io.grpc.{ManagedChannel, ManagedChannelBuilder}

import scala.concurrent.{ExecutionContext, Future}


object CalculatorClient {

  def apply(host: String, port: Int)(implicit ex: ExecutionContext): CalculatorClient = {
    val channel = ManagedChannelBuilder
      .forAddress(host, port)
      .usePlaintext(true)
      .build

    val stub = CalculatorGrpc.stub(channel)
    new CalculatorClient(channel, stub)
  }

}

private[client] class CalculatorClient private(
  private val channel: ManagedChannel,
  private val greeter: CalculatorStub)
  (implicit ex: ExecutionContext) {

  def calculate(name: String): Future[String] = {
    val request = ExpressionRequest(name)
    greeter
      .evaluate(request)
      .map(_.answer)
  }
}