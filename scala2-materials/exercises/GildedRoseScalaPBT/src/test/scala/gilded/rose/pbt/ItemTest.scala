package gilded.rose.pbt

import gilded.rose._
import org.scalacheck.Gen._
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Properties

object ItemTest extends Properties("Item") {
  private def validQuality = choose(0,50)

  property("retains its initial value") = forAllNoShrink(validQuality) { quality =>
    val item = new Item(4, quality)
    item.quality == quality
  }
}
