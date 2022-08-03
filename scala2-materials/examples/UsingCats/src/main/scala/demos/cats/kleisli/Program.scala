package demos.cats.kleisli

import cats.data.Kleisli
import cats.implicits._

import demos.cats.util.Utilities._

object Program {
  private def demoKleisli() {
    val kleisli = Kleisli(propertyViaJVM)
    val composition = kleisli compose kleisli compose kleisli compose kleisli compose kleisli

    val result = composition
      .map(_ + " Atreides")
      .run("Vladimir")

    println(result)
  }

  def main(args: Array[String]): Unit = {
    addAtreidesLineage()
    demoKleisli()

    breakLineage()
    demoKleisli()
  }
}
