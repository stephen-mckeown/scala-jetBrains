package frm.slick

import frm.slick.Program.courses

import java.sql.Date

import slick.jdbc.MySQLProfile.api._

class Deliveries(tag: Tag) extends Table[(Int, Date, Date, String)](tag, "Deliveries") {
  def id = column[Int]("DeliveryNum")

  def begin = column[Date]("StartDate")

  def end = column[Date]("EndDate")

  def courseId = column[String]("CourseNum")

  def * = (id, begin, end, courseId)

  def course = foreignKey("COURSE_FK", courseId, courses)(_.id)
}
