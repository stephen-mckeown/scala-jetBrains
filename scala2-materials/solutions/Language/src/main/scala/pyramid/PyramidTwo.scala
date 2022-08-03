package pyramid

import scala.io.StdIn

object PyramidTwo {
  def main(args : Array[String]) {
    println("Enter the height of the pyramid...")
    val heightString = StdIn.readLine()
    val height = Integer.parseInt(heightString)

    (1 to height)
      .map(num => buildRow(num, height))
      .foreach(println)
  }
  def buildRow(rowNum : Int, height : Int): String = {
    val numSpaces = height - rowNum
    val numHashes = rowNum * 2 - 1

    (" " * numSpaces) + ("#" * numHashes)
  }
}
