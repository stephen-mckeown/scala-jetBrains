package frm.slick

import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Program {
  val courses = TableQuery[Courses]
  val deliveries = TableQuery[Deliveries]

  def main(args: Array[String]): Unit = {
    showTitle()
    showAllCourses()
    showAllCoursesViaStreams()
    showAllCoursesViaProjection()
    showAllDeliveriesWithCourses()
    showAllDeliveriesOfAdvancedCourses()
  }

  private def showTitle(): Unit = {
    println("Demos of the Slick FRM library")
  }

  private def showAllCourses(): Unit = {
    println("All the training courses")
    runDemo { db =>
      db.run(courses.result).map(_.foreach {
        case (id, title, difficulty) =>
          println(s"\tCourse $id is a $difficulty course called $title")
      })
    }
  }

  private def showAllCoursesViaStreams(): Unit = {
    println("All the training courses (via Streams)")
    runDemo { db =>
      db.stream(courses.result).foreach {
        case (id, title, difficulty) =>
          println(s"\tCourse $id is a $difficulty course called $title")
      }
    }
  }

  private def showAllCoursesViaProjection(): Unit = {
    println("All the training courses (via projection)")
    runDemo { db =>
      val query = for (course <- courses)
        yield (LiteralColumn("\tCourse ")
                ++ course.id
                ++ " is a "
                ++ course.difficulty
                ++ " course called "
                ++ course.title)

      db.stream(query.result).foreach(println)
    }
  }

  private def showAllDeliveriesWithCourses(): Unit = {
    println("All the deliveries of courses")
    runDemo { db =>
      val query = for {
        delivery <- deliveries
        course <- delivery.course
      } yield (delivery.id, course.id, course.title)

      db.stream(query.result).foreach {
        case (deliveryId, courseId, title) =>
          println(s"\tDelivery $deliveryId of course $courseId called $title")
      }
    }
  }

  private def showAllDeliveriesOfAdvancedCourses(): Unit = {
    println("All the deliveries of advanced courses")
    runDemo { db =>
      val query = for {
        delivery <- deliveries
        course <- delivery.course if course.difficulty === "ADVANCED"
      } yield (delivery.id, course.title)

      db.stream(query.result).foreach {
        case (deliveryId, title) =>
          println(s"\tDelivery $deliveryId of $title")
      }
    }
  }

  private def runDemo(demo: Database => Future[Unit]): Unit = {
    val db = buildDatabase
    try {
      Await.result(demo(db), Duration.Inf)
    } finally db.close
  }

  private def buildDatabase = Database.forURL(
    url = "jdbc:mysql://localhost/CoursesDB",
    user = "root",
    password = "password"
  )
}
