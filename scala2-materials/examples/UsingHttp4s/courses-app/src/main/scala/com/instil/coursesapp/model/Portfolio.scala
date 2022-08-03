package com.instil.coursesapp.model

import com.instil.coursesapp.model.CourseDifficulty._

import scala.collection.mutable

object Portfolio {
  def buildPortfolio: mutable.HashMap[String, Course] = {
    val portfolio = mutable.HashMap[String, Course]()
    val addCourse = (course: Course, portfolio: mutable.HashMap[String, Course]) => portfolio.addOne((course.id, course))

    addCourse(Course("AB12", "Intro to Scala", BEGINNER, 4), portfolio)
    addCourse(Course("CD34", "JEE Web Development", INTERMEDIATE, 3), portfolio)
    addCourse(Course("EF56", "Meta-Programming in Ruby", ADVANCED, 2), portfolio)
    addCourse(Course("GH78", "OO Design with UML", BEGINNER, 3), portfolio)
    addCourse(Course("IJ90", "Database Access with JPA", INTERMEDIATE, 3), portfolio)
    addCourse(Course("KL12", "Design Patterns in C#", ADVANCED, 2), portfolio)
    addCourse(Course("MN34", "Relational Database Design", BEGINNER, 4), portfolio)
    addCourse(Course("OP56", "Writing MySql Stored Procedures", INTERMEDIATE, 1), portfolio)
    addCourse(Course("QR78", "Patterns of Parallel Programming", ADVANCED, 2), portfolio)
    addCourse(Course("ST90", "C++ Programming for Beginners", BEGINNER, 5), portfolio)
    addCourse(Course("UV12", "UNIX Threading with PThreads", INTERMEDIATE, 2), portfolio)
    addCourse(Course("WX34", "Writing Linux Device Drivers", ADVANCED, 3), portfolio)

    portfolio
  }
}
