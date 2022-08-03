package collections.cinema

import collections.cinema.Rating._

import java.time.LocalDate.of
import java.time.Month._

object Model {
  def greatActionMovies() = List(
    new Movie("Conan", GREAT,
      of(1984, JUNE, 29),
      List("Enough talk!")),

    new Movie("Terminator", GREAT,
      of(1984, OCTOBER, 26),
      List("I'll be back.")),

    new Movie("Terminator 2", BRILLIANT,
      of(1991, JULY, 3),
      List("Come with me if you want to live.",
        "Hasta la vista, baby.",
        "It's in your nature to destroy yourselves.")),

    new Movie("Commando", SUPERB,
      of(1984, OCTOBER, 4),
      List("I have to remind you Sully, this is my weak arm!",
        "I eat Green Berets for breakfast. And right now, I'm very hungry!",
        "Don't disturb my friend, he's dead tired.",
        "Come on Bennett, let's party!",
        "Let off some steam, Bennett.")),

    new Movie("Predator", LIFE_CHANGING,
      of(1987, JUNE, 12),
      List("Get to the Chopper!",
        "Stick around.",
        "If it bleeds, we can kill it.",
        "He's using the trees.",
        "We move, five meter spread, no sound.")),

    new Movie("Total Recall", GREAT,
      of(1990, JUNE, 1),
      List("Get your ass to Mars.",
        "Relax. You'll live longer.",
        "If I am not me, then who the hell am I?",
        "Look who's talking."))
  )
}
