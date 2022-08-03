package numerals

class Numeral(textValue: String, decimalValue: Int) {
  private def contribute(number: Int, buffer: StringBuffer): Int = {
    val times = number / decimalValue
    if (times > 0) {
      (1 to times).foreach(_ => buffer.append(textValue))
      number % decimalValue
    } else {
      number
    }
  }
}

object Numeral {
  private val numerals = Array(
    new Numeral("C", 100),
    new Numeral("XC", 90),
    new Numeral("L", 50),
    new Numeral("XL", 40),
    new Numeral("X", 10),
    new Numeral("IX", 9),
    new Numeral("V", 5),
    new Numeral("IV", 4),
    new Numeral("I", 1))

  def convert(number: Int): String = {
    var adjustedNumber = number
    val result = new StringBuffer
    for (numeral <- numerals) {
      adjustedNumber = numeral.contribute(adjustedNumber, result)
    }
    result.toString
  }
}
