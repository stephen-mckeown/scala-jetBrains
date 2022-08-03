package frm.slick

import slick.jdbc.MySQLProfile.api._

class Courses(tag: Tag) extends Table[(String, String, String)](tag, "Courses") {
  def id = column[String]("CourseNum")

  def title = column[String]("CourseTitle")

  def difficulty = column[String]("CourseType")

  def * = (id, title, difficulty)
}
