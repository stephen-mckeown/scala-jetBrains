package videostore

import PriceCode._

class Movie(val title: String, val pricecode: PriceCode.Value) {
  def cost(daysRented: Int): Double = {
    var cost = 0.0
    pricecode match {
      case REGULAR => {
        cost += 2
        if (daysRented > 2)
          cost += (daysRented - 2) * 1.5
      }
      case NEW_RELEASE => cost += daysRented * 3
      case CHILDRENS => {
        cost += 1.5
        if (daysRented > 3)
          cost += (daysRented - 3) * 1.5
      }
    }
    cost
  }

  def points(daysRented: Int): Int =
    if ((pricecode == NEW_RELEASE) && daysRented > 1) {
      2
    } else {
      1
    }
}
