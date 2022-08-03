package reducing

object Project {
  def main(args: Array[String]): Unit = {
    val data = List(10,20,30,40,50,60)

    val result1 = data.reduce((a, b) => {
      println(s"Lambda invoked with $a and $b")
      a + b
    })
    println(s"First reduction gives: $result1")
    val result2 = data.reduce(_ + _)
    println(s"Second reduction gives: $result2")
    val result3 = data.reduce { (a, b) =>
      a + b
    }
    println(s"Third reduction gives: $result3")

    val fold1 = data.fold(1000)((a, b) => {
      println(s"Lambda invoked with $a and $b")
      a + b
    })
    println(s"First fold gives: $fold1")

    val fold2 = data.foldLeft(1000.0)((a, b) => {
      println(s"Lambda invoked with $a and $b")
      a + b
    })
    println(s"Second fold gives: $fold2")

    val fold3 = data.foldRight(1000.0)((a, b) => {
      println(s"Lambda invoked with $a and $b")
      a + b
    })
    println(s"Third fold gives: $fold3")
  }
}
