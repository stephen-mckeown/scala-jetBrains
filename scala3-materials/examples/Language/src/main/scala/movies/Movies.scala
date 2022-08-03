package movies

import java.time.Month.{JUNE, OCTOBER, JULY}
import java.time.LocalDate
import java.time.LocalDate.of

enum Rating {
    case GREAT, BRILLIANT, SUPERB, LIFE_CHANGING
}

class Movie(val title: String,
            val rating: Rating,
            val releaseDate: LocalDate,
            val quotes: List[String])

def greatActionMovies(): List[Movie] = List(
  Movie("Conan",
          Rating.GREAT,
          of(1984, JUNE, 29),
          List("Enough talk!")),
  Movie("Terminator",
          Rating.GREAT,
          of(1984, OCTOBER, 26),
          List("I'll be back.")),
  Movie("Terminator 2",
          Rating.BRILLIANT,
          of(1991, JULY, 3),
          List("Come with me if you want to live.",
                  "Hasta la vista, baby.",
                  "It's in your nature to destroy yourselves.")),
  Movie("Commando",
          Rating.SUPERB,
          of(1984, OCTOBER, 4),
          List("I have to remind you Sully, this is my weak arm!",
               "I eat Green Berets for breakfast. And right now, I'm very hungry!",
               "Don't disturb my friend, he's dead tired.",
               "Come on Bennett, let's party!",
               "Let off some steam, Bennett.")),
  Movie("Predator",
          Rating.LIFE_CHANGING,
          of(1987, JUNE, 12),
          List("Get to the Chopper!",
               "Stick around.",
               "If it bleeds, we can kill it.",
               "He's using the trees.",
               "We move, five meter spread, no sound.")),
  Movie("Total Recall",
          Rating.GREAT,
          of(1990, JUNE, 1),
          List("Get your ass to Mars.",
               "Relax. You'll live longer.",
               "If I am not me, then who the hell am I?",
               "Look who's talking."))
)

