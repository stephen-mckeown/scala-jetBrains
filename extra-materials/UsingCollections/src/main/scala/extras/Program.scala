package extras

object Program {
  def main(args: Array[String]): Unit = {
    val data = List(10,20,30,40,50)
    val results1 = data.scanLeft(1000)((a, b) => a + b)
    println(results1)

    val results2 = Iterable.unfold(100) { state =>
      if(state < 250) Some(1000 + state, state + 10) else None
    }
    println(results2)
  }
}


//val nextResult = 1000 + state
//val nextState