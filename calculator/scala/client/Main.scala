package client

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.io.StdIn

object Main extends App {

  private final val Port = 1212

  private val cli =
    CalculatorClient("0.0.0.0", Port)

  private def calculate(expression: String): String =
    Await.result(cli.calculate(expression), Duration.Inf)

  private def in =
    Iterator.continually(StdIn.readLine("→ "))
      .takeWhile(Option(_).fold(false)(_.nonEmpty))
      .map { input ⇒ println(s"= ${calculate(input)}"); input }
      .toList

  while (true) in
}
