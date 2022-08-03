package toolkit

object Program {
  def main(args: Array[String]): Unit = {
    def printTitle(title: String)  = println(s"------ $title ------")

    val data = List(
      "ab", "cde", "fghi", "jklmn",
      "op", "qrs", "tyvw", "xyz"
    )

    printTitle("Permutations")
    for(variation <- data.permutations) {
      println(variation)
    }

    printTitle("Contains")
    println(data.containsSlice(List("op", "qrs")))

    printTitle("Regular Operators")
    data.filter(str => str.length > 3)
      .map(str => str.toUpperCase())
      .foreach(str => println(str))

    printTitle("Regular Operators Shortened")
    data.filter(_.length > 3)
      .map(_.toUpperCase())
      .foreach(println)

    printTitle("Partition")
    val results = data.partition(_.length > 3)
    println(results._1)
    println(results._2)

    printTitle("Partition With Destructuring")
    val (longStrings, shortStrings) = data.partition(_.length > 3)
    println(longStrings)
    println(shortStrings)

    printTitle("Finding")
    val result = data.find(_.length > 4)
      .map(_.toUpperCase)
      .getOrElse("Nothing")
    println(result)
  }
}
