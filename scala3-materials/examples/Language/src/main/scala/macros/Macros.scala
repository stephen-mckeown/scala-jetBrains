package macros

import scala.quoted._

def test1()(using Quotes) = {
  val expr = '{ 100 + 50 }
  println("Evaluating Macro")
  println("Type is: " + expr)
  expr
}

inline def test2() = ${ test1() }
