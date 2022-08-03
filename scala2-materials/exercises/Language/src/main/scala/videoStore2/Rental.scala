package videoStore2

class Rental(var movie: Movie, val daysRented: Int) {
  def cost = movie.cost(daysRented)
  def points = movie.points(daysRented)
}
