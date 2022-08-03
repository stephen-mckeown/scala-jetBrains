package testing.word

import org.scalatest.Outcome
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import testing.Accumulator

class AccumulatorTest extends AnyWordSpec with Matchers {
  private var accumulator: Accumulator = null

  override def withFixture(test: NoArgTest): Outcome = {
    accumulator = new Accumulator(10)
    println(s"About to invoke '${test.name}'")
    super.withFixture(test)
  }

  "An Accumulator" can {

    "when created" should {

      "hold its initial value" in {
        accumulator.value shouldEqual 10
      }

      "throw when given a negative value" in {
        intercept[IllegalStateException] {
          new Accumulator(-1)
        }
      }
    }

    "when used" should {

      "support addition" in {
        accumulator.add(15)
        accumulator.value shouldEqual 25
      }

      "support subtraction" in  {
        accumulator.subtract(8)
        accumulator.value shouldEqual 2
      }

      "supports subtraction to zero" in  {
        accumulator.subtract(10)
        accumulator.value shouldEqual 0
      }

      "disallow subtraction below zero" in {
        accumulator.subtract(15)
        accumulator.value shouldEqual 0
      }
    }
  }
}
