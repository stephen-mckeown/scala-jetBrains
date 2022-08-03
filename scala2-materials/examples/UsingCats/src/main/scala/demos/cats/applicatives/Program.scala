package demos.cats.applicatives

import cats.implicits._
import demos.cats.util.Utilities.askQuestion

object Program {
  def main(args: Array[String]): Unit = {
    def buildWelcome(name: String)(place: String) = s"Hello $name from $place"

    val name = askQuestion("What is your name?", "[a-zA-Z]+".r)
    val place = askQuestion("Where do you live?", "[a-zA-Z]+".r)

    val result = place.ap(name.map(buildWelcome))
//    val result = buildWelcome(name.map(_)_)
    println(result)
  }
}
