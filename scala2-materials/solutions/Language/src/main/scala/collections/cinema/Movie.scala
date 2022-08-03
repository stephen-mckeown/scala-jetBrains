package collections.cinema

import java.time.LocalDate

class Movie(val title: String,
            val rating: Rating.Value,
            val releaseDate: LocalDate,
            val quotes: Seq[String])
