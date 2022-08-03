package testing.fun

import org.scalatest.Outcome
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import testing.Accumulator

class AccumulatorTest extends AnyFunSpec with Matchers {
  private var accumulator: Accumulator  = null

  override def withFixture(test: NoArgTest): Outcome = {
    accumulator = new Accumulator(10)
    println(s"About to invoke '${test.name}'")
    super.withFixture(test)
  }

  describe("An Accumulator") {

    describe("(when being created)") {

      it("should have its initial value") {
        accumulator.value shouldEqual 10
      }

      it("should throw when given a negative value") {
        intercept[IllegalStateException] {
          new Accumulator(-1)
        }
      }
    }

    describe("(when in use)") {

      it("supports addition") {
        accumulator.add(15)
        accumulator.value shouldEqual 25
      }

      it("supports subtraction") {
        accumulator.subtract(8)
        accumulator.value shouldEqual 2
      }

      it("supports subtraction to zero") {
        accumulator.subtract(10)
        accumulator.value shouldEqual 0
      }

      it("disallows subtraction below zero") {
        accumulator.subtract(15)
        accumulator.value shouldEqual 0
      }
    }
  }
}
