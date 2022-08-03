package reductions

object Program {
   def main(args : Array[String]) {
     val numbers = List(1,2,3,4,5,6,7,8,9,10)
//     def sumViaReduce(numbers: List[Int]): Unit = {
//       println(numbers.reduce(_+_))
//     }

     def countViaReduce(numbers: List[Int]): Unit = {
       println(numbers)
       var count = 0
        numbers.reduce { (a, b) =>
          println(a)
          count = count +1
          a + b
        }

       println(count)
     }

     def averageViaReduce() {
     }
     def lastViaReduce() {
     }
     def penultimateViaReduce() {
     }
     def reverseViaReduce() {
     }
//     sumViaReduce(numbers)
     countViaReduce(numbers)
     averageViaReduce()
     lastViaReduce()
     penultimateViaReduce()
     reverseViaReduce()
   }
 }
