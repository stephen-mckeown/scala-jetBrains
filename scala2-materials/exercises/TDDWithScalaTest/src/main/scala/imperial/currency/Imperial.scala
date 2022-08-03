package imperial.currency

object Imperial {

  sealed abstract class Currency(
    val penceValue: Int,
    val singularName: String,
    val pluralName: String) {
  }

  case object Guinea extends Currency(252, "guinea", "guineas")

  case object Pound extends Currency(240, "pound", "pounds")

  case object Shilling extends Currency(12, "shilling", "shillings")

  case object Penny extends Currency(1, "penny", "pennies")

  //could populate via Macros etc...
  val currencies: List[Currency] = List(Guinea, Pound, Shilling, Penny)
}
