package logging.db

import logging.Logger

class DatabaseLogger extends Logger {
  override def log(msg: String): Unit = println(s"Logging '$msg' to DB")
}
