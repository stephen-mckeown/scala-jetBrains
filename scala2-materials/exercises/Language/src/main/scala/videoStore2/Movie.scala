package videoStore2


object PriceCode extends Enumeration {
  val CHILDRENS: PriceCode.Value = Value("CHILDRENS")
  val REGULAR: PriceCode.Value = Value("REGULAR")
  val NEW_RELEASE: PriceCode.Value = Value("NEW_RELEASE")
}

class Movie(val name: String, priceCode: PriceCode.Value) {
  def cost(daysRented: Int): Double =
    priceCode match {
      case PriceCode.REGULAR =>  2
      case PriceCode.REGULAR if daysRented > 2 =>  (daysRented - 2) * 1.5
      case PriceCode.NEW_RELEASE => daysRented * 3
      case PriceCode.CHILDRENS => 1.5
      case PriceCode.CHILDRENS if daysRented > 3 => (daysRented - 3) * 1.5
    }

  def points(daysRented: Int) = {
    priceCode match {
      case PriceCode.NEW_RELEASE if daysRented > 1 => 2
      case _  => 1
    }
  }
}
