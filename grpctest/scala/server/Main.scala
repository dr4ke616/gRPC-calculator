package server

import concurrent.ExecutionContext.Implicits.global

object Main extends App {

  private final val Port = 1212

  private val srv =
    CalculatorServer.start(Port)

  srv.blockUntilShutdown()
}
