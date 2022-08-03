package videoStore2

object CommandLine {
  def main(args: Array[String]): Unit = {
    val peterPan = new Movie("Peter Pan", PriceCode.CHILDRENS)
    val theHulk = new Movie("The Hulk", PriceCode.REGULAR)
    val starWars = new Movie("Star Wars", PriceCode.REGULAR)
    val toyStory = new Movie("Toy Story", PriceCode.CHILDRENS)
    val killBill = new Movie("Kill Bill", PriceCode.NEW_RELEASE)
    val r1 = new Rental(peterPan, 2)
    val r2 = new Rental(theHulk, 1)
    val r3 = new Rental(starWars, 3)
    val r4 = new Rental(toyStory, 2)
    val r5 = new Rental(killBill, 4)
    val customer = new Customer("Joe Bloggs")
    customer.addRental(r1)
    customer.addRental(r2)
    customer.addRental(r3)
    customer.addRental(r4)
    customer.addRental(r5)
    System.out.println(customer.statement)
  }
}