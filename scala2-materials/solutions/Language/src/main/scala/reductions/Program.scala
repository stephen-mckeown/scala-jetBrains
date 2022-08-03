package reductions

object Program {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    def sumViaReduce() {
      println("Sum of numbers")
      println(numbers.reduce(_ + _))
    }

    def countViaReduce() {
      println("Count of numbers")
      println(numbers.foldLeft(0)((sum, x) => sum + 1))
    }

    def averageViaReduceV1() {
      def sum = numbers.reduce(_ + _).toDouble
      def count = numbers.foldLeft(0)((sum, _) => sum + 1)

      println("Average of numbers")
      println(sum / count)
    }

    def averageViaReduceV2() {
      val result = numbers.foldLeft((0,0.0)) { (state, num) =>
        val total = state._1 + 1
        val sum = state._2 + num
        (total, sum)
      }

      println("Average of numbers")
      println(result._2 / result._1)
    }

    def lastViaReduce() {
      println("The last number")
      println(numbers.reduce((a, b) => b))
    }

    def penultimateViaReduce() {
      println("The penultimate number")
      println(numbers.foldLeft((0, 0))((a, b) => (a._2, b))._1)
    }

    def reverseViaReduce() {
      val reversed = numbers.foldLeft(List[Int]())(_.prepended(_))

      println("The numbers reversed")
      reversed.foreach(printf("%s ", _))
      println
    }

    sumViaReduce()
    countViaReduce()
    averageViaReduceV1()
    averageViaReduceV2()
    lastViaReduce()
    penultimateViaReduce()
    reverseViaReduce()
  }
}
