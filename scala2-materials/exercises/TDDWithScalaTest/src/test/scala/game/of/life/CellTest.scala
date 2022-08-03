package game.of.life

import org.scalatest.Outcome
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CellTest extends AnyFunSpec with Matchers {
  var cell: Cell = null
  var neighbours: IndexedSeq[Cell] = null

  override def withFixture(test: NoArgTest): Outcome = {
    neighbours = (1 to 8).map(_ => new Cell(Seq.empty))
    cell = new Cell(neighbours)
    super.withFixture(test)
  }

  private def makeNeighboursAlive(range: Range): Unit = range.foreach(neighbours(_).makeAlive())

  describe("A cell") {

    describe("when being created") {

      it("should be dead") {
        cell.isDead shouldBe true
      }

      it("does not accept > 8 neighbours") {
        intercept[IllegalArgumentException] {
          new Cell(Seq.fill(9)(new Cell(Seq.empty)))
        }
      }
    }

    describe("make alive") {


      it("does not accept > 8 neighbours") {
        intercept[IllegalArgumentException] {
          new Cell(Seq.fill(9)(new Cell(Seq.empty)))
        }
      }
    }
  }
}
