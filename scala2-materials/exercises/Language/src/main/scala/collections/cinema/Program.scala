package collections.cinema

object Program {
  def main(args: Array[String]): Unit = {
    val movies = Model.greatActionMovies()
//    allTheMovieTitles(movies)
//    allTheGreatMovieTitles(movies)
//    titleAndRatingOfMoviesFrom1984(movies)
    allTheQuotes(movies)
//    averageQuoteLength(movies)
//    moviesListedByDecade(movies)
//    moviesGroupedByRating(movies)
  }

  def allTheMovieTitles(movies: Seq[Movie]) {
    val titles = movies.map(_.title)
    println(s"The titles of all the movies $titles")
  }

  def allTheGreatMovieTitles(movies: Seq[Movie]) {
   val greatMovies =  movies.filter(_.rating == Rating.GREAT)
     .map(_.title)
    println("Titles of all the movies with a rating of GREAT")
    println(greatMovies)
  }

  def titleAndRatingOfMoviesFrom1984(movies: Seq[Movie]) {
    val asd = movies.filter(_.releaseDate.getYear == 1984)
      .map(a => (a.title, a.rating))
    println("Title and rating of movies released in 1984")
    println(asd)
  }

  def allTheQuotes(movies: Seq[Movie]) {
    val titles = movies.flatMap(_.quotes).toString()
    println("All the quotes")
    println(titles)
  }

  def averageQuoteLength(movies: Seq[Movie]) {
    println("The average length of a quote is")
  }

  def moviesListedByDecade(movies: Seq[Movie]) {
    println("The titles of all the movies from the 1980s")
    println("The titles of all the movies from the 1990s")
  }

  def moviesGroupedByRating(movies: Seq[Movie]) {
    println("The movies grouped by their rating:")
  }

  private def printTabbed(input: String): Unit = println(s"\t$input")

}
