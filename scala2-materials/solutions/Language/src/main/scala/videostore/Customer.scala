package videostore

class Customer(val name: String) {
  private var rentals = List[Rental]()

  def addRental(arg: Rental): Unit = rentals = arg :: rentals

  def totalCost: Double = rentals.foldLeft(0.0)(_ + _.cost)

  def totalPoints: Int = rentals.foldLeft(0)(_ + _.points)

  def statement: String = {
    def header = s"\nRental Record for $name\n"

    def footer: String =
      s"""Amount owed is $totalCost
          |You earned $totalPoints frequent renter points
      """.stripMargin

    def rentalLine(r: Rental) = s"\t${r.daysRented}\t${r.movie.title}\t${r.cost}\n"
    def rentalLines: String = rentals.map(rentalLine).reduce(_ + _)

    header + rentalLines + footer
  }

}
