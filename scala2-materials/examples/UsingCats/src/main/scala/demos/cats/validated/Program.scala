package demos.cats.validated

import cats.implicits._
import demos.cats.util.Utilities.askQuestion

object Program {
  def main(args: Array[String]): Unit = {

    val result = (
      askQuestion("What's your name?", "[A-Za-z]+".r),
      askQuestion("How old are you?", "[0-9]+".r),
      askQuestion("Where do you work?", "(HR|IT|Sales)".r)
    ).mapN(Tuple3[String, String, String])

    println(result)
  }
}
