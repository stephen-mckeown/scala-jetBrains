package com.instil.coursesapp.model

case class Course(id: String,
                  title: String,
                  difficulty: CourseDifficulty.Value,
                  duration: Int)
