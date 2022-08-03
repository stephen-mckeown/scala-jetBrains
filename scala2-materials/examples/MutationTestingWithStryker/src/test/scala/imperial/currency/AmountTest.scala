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

    it("handles pennies") {
      amount.add(Penny)
      amount.toString() shouldEqual "1 penny"

      (2 to 11).foreach(num => {
        amount.add(Penny)
        amount.toString() shouldEqual s"$num pennies"
      })
    }

    it("knows 12 pennies make a shilling") {
      (1 to 12).foreach(_ => amount.add(Penny))
      amount.toString() shouldEqual "1 shilling"
    }

    it("handles shillings") {
      amount.add(Shilling)
      amount.toString() shouldEqual "1 shilling"

      (2 to 19).foreach(num => {
        amount.add(Shilling)
        amount.toString() shouldEqual s"$num shillings"
      })
    }

    it("knows 20 shillings make a pound") {
      (1 to 20).foreach(_ => amount.add(Shilling))
      amount.toString() shouldEqual "1 pound"
    }

    it("knows 21 shillings make a guinea") {
      (1 to 21).foreach(_ => amount.add(Shilling))
      amount.toString() shouldEqual "1 guinea"
    }

    it("handles guineas to 100") {
      amount.add(Guinea)
      amount.toString() shouldEqual "1 guinea"

      (2 to 100).foreach(num => {
        amount.add(Guinea)
        amount.toString() shouldEqual s"$num guineas"
      })
    }

    it("handles guineas and pounds") {
      amount.add(Guinea)
      amount.add(Guinea)
      amount.add(Pound)
      amount.toString() shouldEqual "2 guineas 1 pound"
    }

    it("handles guineas and shillings") {
      amount.add(Guinea)
      amount.add(Guinea)
      amount.add(Shilling)
      amount.toString() shouldEqual "2 guineas 1 shilling"
    }

    it("handles guineas and pence") {
      amount.add(Guinea)
      amount.add(Guinea)
      amount.add(Penny)
      amount.toString() shouldEqual "2 guineas 1 penny"
    }

    it("handles pounds and shillings") {
      amount.add(Pound)
      amount.add(Pound)
      amount.add(Shilling)

      amount.toString() shouldEqual "1 guinea 1 pound"
    }

    it("handles pounds and pennies") {
      amount.add(Pound)
      amount.add(Penny)
      amount.add(Penny)
      amount.toString() shouldEqual "1 pound 2 pennies"
    }

    it("handles shillings and pennies") {
      amount.add(Shilling)
      amount.add(Shilling)
      amount.add(Penny)
      amount.toString() shouldEqual "2 shillings 1 penny"
    }

    it("handles mixed amounts") {
      (1 to 100).foreach(_ => {
        amount.add(Penny)
        amount.add(Shilling)
        amount.add(Pound)
        amount.add(Guinea)
      })
      amount.toString() shouldEqual "200 guineas 8 shillings 4 pennies"
    }
  }
}
