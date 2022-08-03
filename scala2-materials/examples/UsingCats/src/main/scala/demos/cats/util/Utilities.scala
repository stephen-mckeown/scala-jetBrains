package demos.cats.util

import cats.data.{Validated, Writer}
import cats.data.Validated.{Invalid, Valid}

import scala.io.StdIn.readLine
import scala.util.matching.Regex

object Utilities {
  def propertyViaJVM(key: String): Either[String, String] = {
    val result = System.getProperty(key)
    if (result != null) {
      Right(result)
    } else {
      Left(s"No JVM property: $key")
    }
  }

  def addProperties(items: String*) {
    items.reduce((last: String, current: String) => {
      System.setProperty(last, current)
      current
    })
  }

  def askQuestion(title: String, check: Regex): Validated[String, String] = {
    println(title)
    val response = readLine()
    if (check.matches(response)) {
      Valid(response)
    } else {
      Invalid(s""" "$response" does not match "$check" """)
    }
  }

  def askQuestion(title: String, current: Seq[String]): Writer[String, Seq[String]] = {
    println(title)
    val response = readLine()
    Writer(s"""You asked "$title" """, current :+ response)
  }

  def addAtreidesLineage(): Unit = addProperties(
    "Vladimir",
    "Jessica",
    "Paul",
    "Ghanima",
    "Moneo",
    "Siona"
  )

  def breakLineage(): Unit = System.setProperty("Jessica", "Alia")
}
