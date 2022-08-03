package payments

object PaymentDefaults {
  implicit class ModernPayment(input: LegacyPayment) {
    private val amount = input.amount

    def modern1(): Unit = println(s"modern1 $amount")
    def modern2(): Unit = println(s"modern2 $amount")
  }
}
