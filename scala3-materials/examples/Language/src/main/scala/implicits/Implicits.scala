package implicits

trait MakeImportant[T] {
  def escalate(thing: T): T
}

given stringMakeImportant: MakeImportant[String] with {
  def escalate(thing: String): String = thing.toUpperCase()
}

given intMakeImportant: MakeImportant[Int] with {
  def escalate(thing: Int): Int = thing * 100
}

def doImportantWork[T](thing: T)(using imp: MakeImportant[T]): Unit = {
  print("Doing important work with: ")
  println(imp.escalate(thing))
}
