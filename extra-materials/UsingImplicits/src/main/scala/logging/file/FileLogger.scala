package logging.file

import logging.Logger

class FileLogger extends Logger {
  override def log(msg: String): Unit = println(s"Logging '$msg' to file")
}
