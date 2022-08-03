import shopping._
import enumerations._
import movies._
import macros._
import model._
import extensions._
import implicits.{_, given}

@main def foobar(): Unit = {
  creatorApplications()
  extensionMethods()
  basicEnumerations()
  enumerationsAsADTs()
  exportClauses()
  traitParameters()
  opaqueTypeAliases()
  unionTypes()
  intersectionTypes()
  literalTypes()
  givenInstances()
  fakingDoWhile()
  usingMacros()
  collections()
}

def literalTypes(): Unit = {
  def specialFunction(input: "abc" | "def" | "ghi"): Unit = println(input)

  val specialNumber: 123 = 123
  val specialOption: Option[456] = Option(456)

  specialFunction("def")
  specialFunction("ghi")
  //specialFunction("xyz")  //Will not compile
  println(specialNumber)
  println(specialOption.getOrElse(0))
}

def usingMacros() = {
  println("Using macros")
  println(test2())
}

def fakingDoWhile() = {
  println("Output from first weird loop...")
  while ( {
    val x = Math.random()
    println(s"\t$x")
    x > 0.5
  }) ()

  println("Output from second weird loop...")
  while {
    val x = Math.random()
    println(s"\t$x")
    x > 0.5
  } do ()
}

def givenInstances(): Unit = {
  doImportantWork("wibble")
  doImportantWork(123)
}

def intersectionTypes(): Unit = {
  def eatDrinkAndBeMerry(input: Edible & Drinkable) = {
    input.eat()
    input.drink()
  }
  //eatDrinkAndBeMerry(Apple()) //Will not compile
  //eatDrinkAndBeMerry(Milk())  //Will not compile
  eatDrinkAndBeMerry(Soup())
}

def unionTypes(): Unit = {
  def employ(name: String, reason: Degree | WorkExperience | Publication): Unit = {
    print(s"Employing $name because of ")
    reason match {
      case Degree(subject) => println(s"their degree in $subject")
      case WorkExperience(years) => println(s"their $years years experience")
      case Publication(_) => println("they wrote a book")
    }
  }

  employ("Dave", Degree("Physics"))
  employ("Jane", WorkExperience(10))
  employ("Fred", Publication("ABC-123"))
}

def collections(): Unit = {
  def triplesOfQuotes(title: String): Unit = {
    val movies = greatActionMovies()
    println(s"All possible triples of $title quotes")
    movies.find(_.title == title)
      .map(m => m.quotes.combinations(3))
      .fold(println("Not found!"))(_.foreach(println))
  }

  def movieTitlesByMonthReleased(): Unit = {
    val movies = greatActionMovies()
    println("Movie titles grouped by month of release")
    movies.groupMap(_.releaseDate.getMonth)(_.title)
      .foreach(row => {
        val (month, titles) = row
        print(s"\tMovies released in $month: ")
        titles.foreach(t => print(s" '$t'"))
        println()
      })
  }

  triplesOfQuotes("Commando")
  movieTitlesByMonthReleased()
}

def opaqueTypeAliases(): Unit = {
  val shop = new Shop()
  //shop.buy("AB12")  //Will Not Compile

  val item1: ItemID = ItemID("AB12")
  shop.buy(item1)
  shop.buy(ItemID("CD34"))
  shop.buy(ItemID("EF56"))

  println(shop)
}

def traitParameters(): Unit = {
  val pe = new MyPricingEngine()
  println(pe.calcDiscount(List("AB12", "CD34")))
  println(pe.calcDiscount(List("AB12", "CD34", "EF56")))
}

def exportClauses(): Unit = {
  val buffer = new MyBuffer()
  buffer.append("Foo")
  buffer.append("Bar")
  buffer.append("Zed")
  buffer.putIn(3, "Wibble")
  buffer.putIn(12, "Wobble")
  println(buffer)
}

def enumerationsAsADTs(): Unit = {
  def demo(input: Try[Int]): Unit = input.fold(
    msg => println(s"Whoops - $msg"),
    num => println(s"Hurrah - $num")
  )

  System.setProperty("testProp", "123")
  val result1 = readPropertyAsInt("testProp")
  val result2 = readPropertyAsInt("java.vendor")

  demo(result1)
  demo(result2)
}

def basicEnumerations(): Unit = {
  val d = Direction.NORTH
  print(d)
  d.printArrow()
}

def extensionMethods(): Unit = {
  val s1 = "Wibble"
  println(s1.times2())
  println(s1.times3())
  println(s1.times4())
}

def creatorApplications(): Unit = {
  val p1 = Person("Jane", 25)
  val p2 = Person("Dave")

  println(p1)
  println(p2)
}
