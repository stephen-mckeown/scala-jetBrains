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

    describe("when in use") {

      it("can be made alive") {
        cell.makeAlive()
        cell.isDead shouldBe false
      }

      it("can be made dead") {
        cell.makeAlive()
        cell.makeDead()
        cell.isDead shouldBe true
      }

      describe("can change state") {

        it("by becoming alive with 3 live neighbours") {
          makeNeighboursAlive(1 to 3)
          cell.changeState()
          cell.isDead shouldBe false
        }

        it("by staying alive with 3 live neighbours") {
          makeNeighboursAlive(1 to 3)
          cell.makeAlive()
          cell.changeState()
          cell.isDead shouldBe false
        }

        it("by staying alive with 2 live neighbours") {
          makeNeighboursAlive(1 to 2)
          cell.makeAlive()
          cell.changeState()
          cell.isDead shouldBe false
        }

        it("by starving with < 2 neighbours") {
          neighbours(0).makeAlive()
          cell.makeAlive()
          cell.changeState()
          cell.isDead shouldBe true
        }

        it("by overcrowding with > 2 neighbours") {
          makeNeighboursAlive(1 to 4)
          cell.makeAlive()
          cell.changeState()
          cell.isDead shouldBe true
        }
      }
    }
  }
}
