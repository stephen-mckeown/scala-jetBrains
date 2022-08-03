package collections.cinema

object Program {
  def main(args: Array[String]): Unit = {
    val movies = Model.greatActionMovies()
    allTheMovieTitles(movies)
    allTheGreatMovieTitles(movies)
    titleAndRatingOfMoviesFrom1984(movies)
    allTheQuotes(movies)
    averageQuoteLength(movies)
    moviesListedByDecade(movies)
    moviesGroupedByRating(movies)
  }

  def allTheMovieTitles(movies: Seq[Movie]) {
    println("The titles of all the movies")
    movies.map(m => m.title).foreach(printTabbed)
  }

  def allTheGreatMovieTitles(movies: Seq[Movie]) {
    println("Titles of all the movies with a rating of GREAT")
    movies.filter(m => m.rating == Rating.GREAT)
          .map(m => m.title)
          .foreach(printTabbed)
  }

  def titleAndRatingOfMoviesFrom1984(movies: Seq[Movie]) {
    println("Title and rating of movies released in 1984")
    movies.filter(m => m.releaseDate.getYear == 1984)
          .map(m => (m.title, m.rating))
          .foreach(pair => println(s"\t${ pair._1 } rated ${ pair._2 }"))
  }

  def allTheQuotes(movies: Seq[Movie]) {
    println("All the quotes")
    movies.flatMap(m => m.quotes)
          .foreach(printTabbed)
  }

  def averageQuoteLength(movies: Seq[Movie]) {
    println("The average length of a quote is")
    val lengthsOfQuotes = movies
      .flatMap(m => m.quotes)
      .map(_.length)

    val average = lengthsOfQuotes.sum.toDouble / lengthsOfQuotes.size
    printf("\t%.2f\n", average)
  }

  def moviesListedByDecade(movies: Seq[Movie]) {
    val results = movies.partition(m => m.releaseDate.getYear < 1990)

    println("The titles of all the movies from the 1980s")
    results._1
      .map(m => m.title)
      .foreach(printTabbed)

    println("The titles of all the movies from the 1990s")
    results._2
      .map(m => m.title)
      .foreach(printTabbed)
  }

  def moviesGroupedByRating(movies: Seq[Movie]) {
    println("The movies grouped by their rating:")
    movies.groupBy(_.rating)
      .foreach(entry => {
        println(s"\tMovies with a rating of ${entry._1}")
        entry._2
          .map(_.title)
          .foreach(title => println(s"\t\t$title"))
      })
  }

  private def printTabbed(input: String): Unit = println(s"\t$input")

}
