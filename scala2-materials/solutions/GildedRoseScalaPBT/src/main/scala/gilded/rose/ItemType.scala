package gilded.rose

sealed trait ItemType {
  def apply(days: Int, quality: Int): Int
}

case object RegularItemType extends ItemType {
  override def apply(days: Int, quality: Int): Int = {
    if (quality == 0) {
      0
    } else if (days < 0) {
      val newQuality = quality - 2
      //this check was discovered via PBT
      if(newQuality < 0) 0 else newQuality
    } else {
      quality - 1
    }
  }
}

case object AgedBrieType extends ItemType {
  override def apply(days: Int, quality: Int): Int = if(quality == 50) 50 else quality + 1
}

case object SulfurasType extends ItemType {
  override def apply(days: Int, quality: Int): Int = quality
}

case object BackstagePassType extends ItemType {
  override def apply(days: Int, quality: Int): Int = {
    if (days < 0) {
      0
    } else {
      val newQuality = if (days <= 5) {
        quality + 3
      } else if (days <= 10) {
        quality + 2
      } else {
        quality + 1
      }
      if(newQuality < 50) newQuality else 50
    }
  }
}



