package videostore

object PriceCode extends Enumeration {
  val CHILDRENS: PriceCode.Value = Value("Childrens")
  val REGULAR: PriceCode.Value = Value("Regular")
  val NEW_RELEASE: PriceCode.Value = Value("New Release")
}
