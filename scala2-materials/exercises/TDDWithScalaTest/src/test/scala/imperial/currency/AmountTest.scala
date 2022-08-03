package imperial.currency

import imperial.currency.Imperial.{Guinea, Penny, Pound, Shilling}
import org.scalatest.Outcome
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AmountTest extends AnyFunSpec with Matchers {
  private var amount: Amount = null

  override def withFixture(test: NoArgTest): Outcome = {
    amount = new Amount()
    super.withFixture(test)
  }

  describe("An Amount") {

    it("is initially empty") {
      amount.toString() shouldEqual "Nothing"
    }
  }
}
