package client

import io.grpc.{ManagedChannel, ManagedChannelBuilder}
import protogen.calculator.{CalculatorGrpc, ExpressionRequest}

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
 private val greeter: CalculatorGrpc.CalculatorStub)
 (implicit ex: ExecutionContext) {

 def calculate(name: String): Future[String] = {
   val request = ExpressionRequest(name)
   greeter
     .evaluate(request)
     .map(_.answer)
 }
}
