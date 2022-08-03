package enumerations

enum Direction {
  case NORTH, SOUTH, EAST, WEST

  def printArrow() = {
      var arrow = '?'
      this match {
          case WEST  => arrow = 0x2190
          case EAST  => arrow = 0x2192
          case NORTH => arrow = 0x2191
          case SOUTH => arrow = 0x2193
      }
      println(arrow)
  }
}

enum Try[+T] {
  case Success(val result: T) extends Try[T]
  case Failure(val error: String) extends Try[Nothing]

  def fold(errorHandler: String => Unit,
           resultHandler: T => Unit) = {
    this match {
      case Success(result) => resultHandler(result)
      case Failure(error) => errorHandler(error)
    }
  }
}

def readPropertyAsInt(name: String): Try[Int] = {
  val propertyValue = System.getProperty(name)
  try {
    Try.Success(Integer.parseInt(propertyValue))
  } catch {
    case ex: NumberFormatException => Try.Failure(ex.getMessage)
  }
}