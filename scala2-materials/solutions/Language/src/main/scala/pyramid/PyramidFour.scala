package pyramid

import scala.io.StdIn

object PyramidFour {
  def pyramidRow(rowNum: Int, height: Int): String = {
      val numSpaces = height - rowNum
      val numHashes = rowNum * 2 - 1

      (" " * numSpaces) + ("#" * numHashes)
  }
  def squareRow(rowNum: Int, height: Int): String = {
      if (rowNum == 1 || rowNum == height) {
        "########"
      } else {
        "#      #"
      }
  }
  def main(args: Array[String]) {
    println("Enter the height for the shapes...")
    val heightString = StdIn.readLine()
    val height = Integer.parseInt(heightString)

    val printShapeAtHeight = printShape(height)_
    printShapeAtHeight(squareRow)
    println
    printShapeAtHeight(pyramidRow)
  }

  def printShape(height: Int)(func: (Int, Int) => String) {
    for (rowNum <- 1 to height) {
      println(func(rowNum, height))
    }
  }
}
