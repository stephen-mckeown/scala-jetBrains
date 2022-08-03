package videostore

class Rental (val movie : Movie,  val daysRented : Int) {
  def cost: Double = movie.cost(daysRented)
  def points: Int = movie.points(daysRented)
}
