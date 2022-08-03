package demos.cats.io

import cats.effect.{ExitCode, IO, IOApp, Resource}

import java.io._

object Program extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val resource = buildResource("input/quote.txt")
    for {
      r1 <- useResource(resource)
      _ <- IO(println(r1))
    } yield ExitCode.Success
  }

  private def buildResource(path: String) = {
    Resource.make {
      IO(new BufferedReader(new FileReader(path)))
    } { inStream =>
      IO(inStream.close()).handleErrorWith(_ => IO.unit)
    }
  }

  private def useResource(resource: Resource[IO, BufferedReader]) = {
    resource.use { reader =>
      IO(reader.readLine())
    }
  }
}
