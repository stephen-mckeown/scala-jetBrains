package partials

import scala.io.Source

object Program {
 def main(args : Array[String]) {

   val f1 = processLines(line => line.endsWith("36"))_
   val f2 = processLines(line => line.startsWith("200"))_
   val f3 = processLines(line => line.matches("^19[5-8]{1}.+"))_

//   f1("input.txt")
//   f2("input.txt")
   f3("input.txt")


 }
 def processLines(a: String => Boolean)(file: String): Unit = {
  for (line <- Source.fromFile(file).getLines) {
   if(a(line)) println(line)
  }
 }
}
