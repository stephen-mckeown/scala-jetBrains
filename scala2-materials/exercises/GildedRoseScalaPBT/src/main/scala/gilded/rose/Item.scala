package gilded.rose

class Item(var sellIn: Int,
           var quality: Int,
           val itemType: ItemType) {
  if (quality < 0) {
    throw new IllegalArgumentException("Quality cannot be negative")
  } else if (quality > 50) {
    throw new IllegalArgumentException("Quality cannot exceed fifty")
  }

  def this(sellIn: Int, quality: Int) {
    this(sellIn, quality, RegularItemType)
  }

  def endOfDay(): Unit = {
    //Use -1 to signify expired
    if (sellIn >= 0) sellIn -= 1
    quality = itemType.apply(sellIn, quality)
  }
}
