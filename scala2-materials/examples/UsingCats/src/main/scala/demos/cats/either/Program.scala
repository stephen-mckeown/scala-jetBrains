package demos.cats.either

import demos.cats.util.Utilities._

object Program {
  def main(args: Array[String]): Unit = {
    addAtreidesLineage()
    demoEitherWithMap

    breakLineage()
    demoEitherWithMap
  }

  private def demoEitherWithMap = {
    val result = for {
      r1 <- propertyViaJVM("Vladimir")
      r2 <- propertyViaJVM(r1)
      r3 <- propertyViaJVM(r2)
      r4 <- propertyViaJVM(r3)
      r5 <- propertyViaJVM(r4)
    } yield r5

    println(result.map(_ + " Atreides"))
  }
}
