package com.instil.coursesapp.model

object CourseDifficulty extends Enumeration {
  type Difficulty = CourseDifficulty.Value
  val BEGINNER: Difficulty = Value("BEGINNER")
  val INTERMEDIATE: Difficulty = Value("INTERMEDIATE")
  val ADVANCED: Difficulty = Value("ADVANCED")

}
