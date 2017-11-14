package helloworld

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  import server.HelloWorldServer
  import client.HelloWorldClient

  private final val Port = 1212

  private val srv =
    HelloWorldServer.start(Port)

  //srv.blockUntilShutdown()

  private val cli =
    HelloWorldClient("0.0.0.0", Port)

  cli.greet("adam")
  cli.greet("pop")

  Thread.sleep(1000)
}
