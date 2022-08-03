package testing

class Accumulator(private var current: Int) {
  if(current < 0) {
    throw new IllegalStateException("Initial value cannot be negative")
  }

  def add(num: Int): Unit = current += num

  def subtract(num: Int): Unit = {
    val result = current - num
    current = if(result < 0) 0 else result
  }

  def value(): Int = current
}
