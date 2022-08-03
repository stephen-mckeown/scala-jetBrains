package game.of.life

import game.of.life.CellState._

class Cell(_neighbours: Seq[Cell]) {
  if (_neighbours.length > 8) {
    throw new IllegalArgumentException("Too Many Neighbours")
  }

  private val neighbours = List.from(_neighbours)
  private var state = Dead

  def makeAlive(): Unit = state = Alive

  def makeDead(): Unit = state = Dead

  def isDead: Boolean = state == Dead

  def changeState(): Unit = {
    val livingNeighbours = neighbours.count(_.state == Alive)

    var result = Dead
    if (state == Dead && livingNeighbours == 3) {
      result = Alive
    } else if (state == Alive) {
      if (livingNeighbours == 2 || livingNeighbours == 3) {
        result = Alive
      }
    }

    state = result
  }
}
