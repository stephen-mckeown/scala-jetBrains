package game.of.life

object CellState extends Enumeration {
  type CellState = Value
  val Alive: CellState = Value("Alive")
  val Dead: CellState = Value("Dead")
}
