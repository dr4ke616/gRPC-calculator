package client

import java.util.logging.Logger

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object Main extends App {

  private val log: Logger =
    Logger.getLogger(classOf[CalculatorClient].getName)

  private final val Port = 1212

  private val cli =
    CalculatorClient("0.0.0.0", Port)

  val fut = cli
    .calculate("14 + 3")
    .recover { case th: Throwable ⇒ log.severe(th.getStackTrace.mkString("\n"))}

  log.info(s"Answer: ${Await.result(fut, Duration.Inf)}")
}
