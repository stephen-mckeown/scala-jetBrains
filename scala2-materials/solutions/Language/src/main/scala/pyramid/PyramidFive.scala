package pyramid

import scala.io.StdIn

object PyramidFive {
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

    val printSquare = printShape(squareRow) _
    val printPyramid = printShape(pyramidRow) _

    printSquare(height);
    println
    printPyramid(height);
  }

  def printShape(codeBlock: (Int, Int) => String)(height: Int) {
    for (rowNum <- 1 to height) {
      println(codeBlock(rowNum, height))
    }
  }
}
