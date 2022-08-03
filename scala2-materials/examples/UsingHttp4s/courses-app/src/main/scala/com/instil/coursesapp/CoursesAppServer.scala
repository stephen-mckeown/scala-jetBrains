package com.instil.coursesapp

import cats.effect.{ConcurrentEffect, ContextShift, Timer}
import cats.implicits._
import com.instil.coursesapp.model.Portfolio
import fs2.Stream
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.middleware.Logger

import scala.concurrent.ExecutionContext.global

object CoursesAppServer {

  def stream[F[_] : ConcurrentEffect](implicit T: Timer[F], context: ContextShift[F]): Stream[F, Nothing] = {
    val courses = Courses(Portfolio.buildPortfolio)

    val httpApp = (
        CoursesAppRoutes.staticContentRoutes[F] <+>
        CoursesAppRoutes.coursesRoutes[F](courses)
      ).orNotFound

    val finalHttpApp = Logger.httpApp(true, true)(httpApp)

    BlazeServerBuilder[F](global)
      .bindHttp(8080, "0.0.0.0")
      .withHttpApp(finalHttpApp)
      .serve
  }.drain
}
