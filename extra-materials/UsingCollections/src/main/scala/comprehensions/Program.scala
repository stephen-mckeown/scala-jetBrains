package comprehensions

object Program {
  def main(args: Array[String]): Unit = {
    def gen1() = List("Up", "Down", "Left", "Right")
    def gen2() = List("North", "South", "East", "West")

    val results1 = for {
      x <- gen1()
      y <- gen2()
      z = 123
    } yield s"$x$y$z"

    val results2 = gen1().flatMap { x =>
      gen2().map { y =>
        val z = 123
        s"$x$y$z"
      }
    }

    println(results1)
    println(results2)
  }
}
