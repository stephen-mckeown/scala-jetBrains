package com.instil.coursesapp

import cats.effect.{Blocker, ContextShift, Sync}
import cats.implicits._
import com.instil.coursesapp.model.Course
import org.http4s.circe.CirceEntityCodec.{circeEntityDecoder, circeEntityEncoder}
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Response, StaticFile, Status}

import java.io.File
import java.util.concurrent.Executors

object CoursesAppRoutes {
  def staticContentRoutes[F[_] : Sync](implicit context: ContextShift[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    val blockingPool = Executors.newSingleThreadExecutor()
    val blocker = Blocker.liftExecutorService(blockingPool)
    import dsl._
    HttpRoutes.of[F] {
      case req@GET -> Root =>
        StaticFile
          .fromFile(new File("content/client.html"), blocker, Some(req))
          .getOrElse(Response[F](Status.NotFound))
    }
  }

  def coursesRoutes[F[_] : Sync](courses: Courses): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import Courses._
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "courses" =>
        for {
          resp <- Ok(courses.portfolio.values)
        } yield resp

      case GET -> Root / "courses" / id =>
        for {
          resp <- Ok(courses.portfolio(id))
        } yield resp

      case DELETE -> Root / "courses" / id => {
        courses.portfolio
          .remove(id)
          .map(_ => Ok(s"$id removed"))
          .getOrElse(NotFound())
      }

      case request@PUT -> Root / "courses" / id => {
        for {
          body <- request.as[Course]
          resp <- {
            courses.portfolio.update(body.id, body)
            Ok(s"$id added or updated")
          }
        } yield resp
      }
    }
  }
}
