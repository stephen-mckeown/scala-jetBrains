package imperial.currency

import imperial.currency.Imperial.Currency

class Amount {
  private var amount: Int = 0

  def add(currency: Currency): Unit = amount += currency.penceValue

  override def toString: String = if(amount == 0) "Nothing" else value()

  private def value(): String = ""
}
