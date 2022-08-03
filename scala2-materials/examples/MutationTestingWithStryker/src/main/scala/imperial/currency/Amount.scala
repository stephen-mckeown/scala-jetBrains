package imperial.currency

import imperial.currency.Imperial.{Currency, currencies}

class Amount {
  private var amount: Int = 0

  def add(currency: Currency): Unit = amount += currency.penceValue

  override def toString: String = if(amount == 0) "Nothing" else value()

  private def value(): String = {
    def convert(current: Int, index: Int): String = {
      def pickLabel(input: Int, c: Currency) = if(input > 1) c.pluralName else c.singularName
      
      val currency = currencies(index)
      val times = current / currency.penceValue
      val remainder = current % currency.penceValue

      val contribution = if(times > 0) s"$times ${pickLabel(times, currency)} " else ""
      if(remainder > 0) {
        s"$contribution${convert(remainder, index + 1)}"
      } else {
        contribution
      }
    }
    convert(amount,0).trim
  }
}
