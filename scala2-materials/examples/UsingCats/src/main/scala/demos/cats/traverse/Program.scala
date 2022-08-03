package demos.cats.traverse

import cats.implicits._
import demos.cats.util.Utilities.propertyViaJVM
import java.lang.System.setProperty

object Program {
  def main(args: Array[String]): Unit = {
    setProperty("foo", "result1")
    setProperty("bar", "result2")
    setProperty("zed", "result3")

    val correctNames = List("foo", "bar", "zed")
    val erroneousNames = List("foo", "bad", "bar")

    print("Mapping over correct names:\n\t")
    correctNames.map(propertyViaJVM).foreach(str => print(s"$str "))

    print("\nMapping over erroneous names:\n\t")
    erroneousNames.map(propertyViaJVM).foreach(str => print(s"$str "))

    print("\nTraversing over correct names:\n\t")
    print(correctNames.traverse(propertyViaJVM))

    print("\nTraversing over erroneous names:\n\t")
    print(erroneousNames.traverse(propertyViaJVM))
  }
}
