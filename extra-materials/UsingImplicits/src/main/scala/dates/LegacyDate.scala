package dates

class LegacyDate(val theDate: String) {
  def legacy1(): Unit = println(s"legacy1 $theDate")
  def legacy2(): Unit = println(s"legacy2 $theDate")
}
