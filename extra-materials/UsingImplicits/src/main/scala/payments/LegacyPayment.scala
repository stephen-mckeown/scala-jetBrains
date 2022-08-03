package payments

class LegacyPayment(val amount: Double) {
  def legacy1(): Unit = println(s"legacy1 $amount")
  def legacy2(): Unit = println(s"legacy2 $amount")
}
