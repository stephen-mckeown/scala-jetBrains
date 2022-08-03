package gilded.rose.pbt

import gilded.rose._
import org.scalacheck.Gen._
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.{Gen, Prop, Properties}

object ItemTest extends Properties("Item") {
  private def validQuality = choose(0,50)
  private def negativeQuality = negNum[Int]
  private def excessiveQuality = choose(51, 10000)
  private def daysToHundred = choose(1, 100)
  private def itemType: Gen[ItemType] = oneOf(Seq(
    RegularItemType,
    AgedBrieType,
    SulfurasType,
    BackstagePassType
  ))

  property("retains its initial value") = forAllNoShrink(validQuality) { quality =>
    val item = new Item(4, quality)
    item.quality == quality
  }

  property("cannot be created with negative quality") = forAllNoShrink(negativeQuality) { quality =>
    try {
      val item = new Item(4, quality)
      false
    } catch {
      case e: IllegalArgumentException => true
      case _: Throwable => false
    }
  }

  property("cannot be created with excessive quality") = forAllNoShrink(excessiveQuality) { quality =>
    lazy val item = new Item(4, quality)
    Prop.throws(classOf[IllegalArgumentException]) {
      item
    }
  }

  property("legendary items never lose quality") = forAllNoShrink(validQuality, daysToHundred) { (quality, days) =>
    val item = new Item(days, quality, SulfurasType)
    val testDays = days * 2

    (1 to testDays).foreach(_ => item.endOfDay())
    item.quality == quality
  }

  property("quality is never negative") = forAllNoShrink(validQuality, daysToHundred, itemType) { (quality, days, theType) =>
    val item = new Item(days, quality, theType)
    val testDays = days * 2

    (1 to testDays).foreach(_ => item.endOfDay())
    item.quality >= 0
  }

  property("quality never exceeds fifty") = forAllNoShrink(validQuality, daysToHundred, itemType) { (quality, days, theType) =>
    val item = new Item(days, quality, theType)
    val testDays = days * 2

    (1 to testDays).foreach(_ => item.endOfDay())
    item.quality <= 50
  }
}
