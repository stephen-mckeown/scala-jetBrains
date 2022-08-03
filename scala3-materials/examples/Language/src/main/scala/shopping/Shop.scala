package shopping

import scala.collection.mutable.Stack

opaque type ItemID = String
object ItemID {
    def apply(str: String): ItemID = str
}

class Shop {
  val purchases = Stack[ItemID]()
  def buy(item: ItemID) = purchases.push(item)
  override def toString() = purchases.toString()
}