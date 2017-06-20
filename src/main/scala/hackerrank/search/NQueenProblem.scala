package hackerrank.search

import scala.collection.mutable.ListBuffer

/**
  * Created by mokarakaya on 22.10.2016.
  */
object NQueenProblem {

  def solve(positions: ListBuffer[Position], n: Int, row: Int): Boolean = {
    if (row == n) return true
    else {
      for (column <- 1 to n) {
        if (isSafe(positions, row, column)) {
          positions.+=(Position(row,column))
          if (solve(positions, n, row + 1)) return true
          else{
            positions.remove(positions.length-1)
          }
        }
      }
    }
    false
  }

  def isSafe(positions: ListBuffer[Position], row: Int, column: Int): Boolean = {
    positions.foreach(position => {
      if (position.row == row
        || position.column == column
        || position.row - position.column == row - column
        || position.row + position.column == row + column) return false
    })
    true
  }



  def main(args: Array[String]): Unit = {
    val n = 5
    val positions = new ListBuffer[Position]
    if (solve(positions, n, 0)) positions.foreach(position => println(position.row + ":" + position.column))
    else print("sorry")
  }
}

case class Position(row:Int,column:Int)