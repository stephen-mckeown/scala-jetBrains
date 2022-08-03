package model

class Person(name: String, age: Int) {
  def this(name: String) = this(name, 27)
  override def toString = s"$name aged $age"
}

class MyBuffer {
  val sb = new StringBuffer()
  export sb.append
  export sb.{ insert => putIn }
  override def toString: String = sb.toString()
}

trait PricingEngine(val minPurchases: Int) {
  def calcDiscount(purchases: List[String]) : Double
}

class MyPricingEngine extends PricingEngine(3) {
  override def calcDiscount(purchases: List[String]): Double = {
    if purchases.length >= minPurchases then 100.0 else 0.0
  }
}

case class WorkExperience(val years: Int)
case class Degree(val subject: String)
case class Publication(val isbn: String)

trait Edible {
  def eat(): Unit
}

trait Drinkable {
  def drink(): Unit
}

class Apple extends Edible {
  override def eat(): Unit = println("Eating an Apple")
}

class Milk extends Drinkable {
  override def drink(): Unit = println("Drinking some Milk")
}

class Soup extends Edible with Drinkable {
  override def eat(): Unit = println("Eating Soup")
  override def drink(): Unit = println("Drinking Soup")
}

