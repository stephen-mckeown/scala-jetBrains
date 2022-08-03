package pyramid

import scala.io.StdIn

object Pyramid {
  def main(args : Array[String]) {
    println("Enter the height of the pyramid...")
    val heightString = StdIn.readLine()
    val height = Integer.parseInt(heightString)

    println(s"Here is a pyramid of height $height")

    for (
      num <- 1 to height
    ) {
      val res = num * 2 - 1
      println(" " * res + "#" * num )
    }
  }
}


