package com.instil.coursesapp

import cats.effect.IO
import com.instil.coursesapp.model.{Course, CourseDifficulty}
import io.circe.syntax.EncoderOps
import io.circe.{Decoder, Encoder, HCursor, Json}
import org.http4s.EntityDecoder
import org.http4s.circe.jsonOf

import scala.collection.mutable

class Courses(val portfolio: mutable.HashMap[String, Course])

object Courses {
  def apply(portfolio: mutable.HashMap[String, Course]): Courses = new Courses(portfolio)

  implicit val CourseEncoder: Encoder[Course] = new Encoder[Course] {
    override def apply(course: Course): Json = Json.obj(
      "id" -> course.id.asJson,
      "title" -> course.title.asJson,
      "difficulty" -> course.difficulty.toString.asJson,
      "duration" -> course.duration.asJson
    )
  }

  implicit val CourseDecoder: Decoder[Course] = new Decoder[Course] {
    override def apply(c: HCursor): Decoder.Result[Course] =
      for {
        id <- c.get[String]("id")
        title <- c.get[String]("title")
        difficulty <- c.get[String]("difficulty")
        duration <- c.get[Option[Int]]("duration")
      } yield Course(id, title, CourseDifficulty.withName(difficulty), duration.getOrElse(0))
  }
  implicit val courseEntityDecoder: EntityDecoder[IO, Course] = jsonOf[IO, Course]
}


