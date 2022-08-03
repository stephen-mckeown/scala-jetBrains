package gilded.rose.tdd

import gilded.rose._
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ItemTest extends AnyFunSpec with Matchers {
  describe("An Item") {

    describe("when being created") {

      it("should retain its initial value") {
        val item = new Item(4, 10)
        item.quality shouldEqual 10
      }

      it("should throw when given a negative quality") {
        intercept[IllegalArgumentException] {
          new Item(4, -1)
        }
      }

      it("should throw when given a quality over fifty") {
        intercept[IllegalArgumentException] {
          new Item(4, 51)
        }
      }
    }

    describe("when of type Regular") {

      it("should decrease in quality to zero") {
        val item = new Item(4, 3)
        assertQuality(item, 2, 1, 0)
      }
    }

    describe("when of type Aged Brie") {

      it("should increase in quality over time") {
        val item = new Item(3, 10, AgedBrieType)
        assertQuality(item, 11, 12, 13, 14, 15)
      }

      it("should never increase in quality over fifty") {
        val item = new Item(3, 48, AgedBrieType)
        assertQuality(item, 49, 50, 50, 50, 50)
      }
    }

    describe("when of type Sulfuras") {
      it("should never change quality") {
        val item = new Item(3, 30, SulfurasType)
        assertQuality(item, 30, 30, 30, 30, 30)
      }
    }

    describe("when of type Backstage Pass") {
      it("should increase in value when ten days remain") {
        val item = new Item(12, 20, BackstagePassType)
        assertQuality(item, 21, 23, 25, 27)
      }

      it("should increase in value when five days remain") {
        val item = new Item(8, 20, BackstagePassType)
        assertQuality(item, 22, 24, 27, 30);
      }

      it("should lose all value after concert") {
        val item = new Item(3, 20, BackstagePassType)
        assertQuality(item, 23, 26, 29, 0, 0, 0)
      }
    }

    it("should never decrease in quality below zero") {
      val item = new Item(4, 2)
      assertQuality(item, 1, 0, 0)
    }

    it("should degrade twice as fast after expiry") {
      val item = new Item(4, 10)
      assertQuality(item, 9, 8, 7, 6, 4, 2, 0)
    }
  }

  private def assertQuality(item: Item, qualityValues: Int*) {
    qualityValues.indices.foreach(num => {
      item.endOfDay()
      assert(qualityValues(num) == item.quality)
    })
  }
}
