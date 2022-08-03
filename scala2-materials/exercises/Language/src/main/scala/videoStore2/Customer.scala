package videoStore2

import videoStore2.Rental
import scala.::

class Customer(val name: String) {
 var rentals: List[Rental] = List()
//  var rentals = List[Rental]()

  def addRental(arg: Rental) = {
    rentals = arg :: rentals
  }

//  def totalCost = {
//    rentals.foldRight(0.0)(_.cost + _)
//  }
//
//  private def totalPoints = {
//    rentals.foldRight(0.0)(_.points + _)
//  }

  def statement: String = {
    def totalCost = rentals.foldRight(0.0)(_.cost + _)
    def totalPoints = rentals.foldRight(0.0)(_.points + _)



//    val result = new StringBuilder(s"\nRental Record for $name \n")
//    for (rental <- rentals){
//      result.append(
//        s"""
//           |${rental.movie.name} \t ${rental.daysRented}  \t ${rental.cost}
//           |""".stripMargin)
//    }
//    result.append("Amount owed is " + totalCost + "You earned " + totalPoints)
//    result.toString()

    def rentalLines() = rentals.map { rental =>
      s"\t${rental.daysRented}\t${rental.movie.name}\t${rental.cost}"
    }.mkString("\n")

    s"""
       |Rental Record for $name
       |${rentalLines()}
       |Amount owed is $totalCost
       |You earned $totalPoints frequent renter points
       |""".stripMargin

  }
}
