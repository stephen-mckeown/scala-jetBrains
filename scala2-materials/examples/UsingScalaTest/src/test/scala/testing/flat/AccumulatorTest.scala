package testing.flat

import org.scalatest.Outcome
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import testing.Accumulator

class AccumulatorTest extends AnyFlatSpec with Matchers {
  private var accumulator: Accumulator  = null

  override def withFixture(test: NoArgTest): Outcome = {
    accumulator = new Accumulator(10)
    println(s"About to invoke '${test.name}'")
    super.withFixture(test)
  }

  it should "be created with its initial value" in {
    accumulator.value shouldEqual 10
  }

  it should "throw when created with a negative value" in {
    intercept[IllegalStateException] {
      new Accumulator(-1)
    }
  }

  it should "support addition" in {
    accumulator.add(15)
    accumulator.value shouldEqual 25
  }

  it should "support subtraction" in {
    accumulator.subtract(8)
    accumulator.value shouldEqual 2
  }

  it should "supports subtraction to zero" in {
    accumulator.subtract(10)
    accumulator.value shouldEqual 0
  }

  it should "disallow subtraction below zero" in {
    accumulator.subtract(15)
    accumulator.value shouldEqual 0
  }
}
