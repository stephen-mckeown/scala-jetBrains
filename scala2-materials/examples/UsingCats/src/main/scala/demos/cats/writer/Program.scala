package demos.cats.writer

import cats.implicits._
import demos.cats.util.Utilities.askQuestion

object Program {
  def main(args: Array[String]): Unit = {
    val result = for {
      r1 <- askQuestion("What's your name?", List.empty)
      r2 <- askQuestion("Where do you live?", r1)
      r3 <- askQuestion("Kirk, Picard or Janeway?", r2)
    } yield r3

    val (log, answers) = result.run
    println(s"Log is: $log")
    println(s"Answers are: $answers")
  }
}
