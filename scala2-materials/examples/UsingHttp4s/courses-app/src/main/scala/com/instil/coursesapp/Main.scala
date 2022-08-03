package com.instil.coursesapp

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    CoursesAppServer.stream[IO].compile.drain.as(ExitCode.Success)
  }
}
