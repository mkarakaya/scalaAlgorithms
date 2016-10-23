package search

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.StdIn

/**
  * Created by mokarakaya on 22.10.2016.
  */
object CountLuck {

  def solve(matrix: Array[Array[Char]], row: Int, column: Int, pRow:Int, pColumn:Int, k: Int): Int = {
    if(matrix(row)(column)=='*') return k
    else{
      val moves= getPossibleMoves(matrix,row,column,pRow,pColumn)
      moves.foreach(move =>{
        val kFound= solve(matrix,move.row,move.column,row,column, if(moves.size>1)k+1 else k )
        if(kFound != -1) return kFound
      })
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val numberOfTests = StdIn.readLine().toInt
    for (i <- 1 to numberOfTests) {
      val input = StdIn.readLine().split(" ")
      val n = input(0).toInt
      val m = input(1).toInt
      val matrix = Array.ofDim[Char](n, m)
      for (j <- 0 to n - 1) {
        matrix(j) = StdIn.readLine().toCharArray
      }
      val k = StdIn.readLine().toInt
      val initMove= initPosition(matrix)
      val kFound= solve(matrix,initMove.row,initMove.column,initMove.row,initMove.column,0)
      if(k==kFound) println("Impressed") else println("Oops!")
    }
  }
  def initPosition(matrix: Array[Array[Char]]) :Move = {
    for(i <- 0 to matrix.size-1){
      for(j <- 0 to matrix(i).size-1){
        if(matrix(i)(j)=='M'){
          return Move(i,j)
        }
      }
    }
    Move(-1,-1)
  }
  def possibleMove(matrix: Array[Array[Char]],row: Int, column: Int): Boolean = {
    val character =matrix(row)(column)
    character=='.' || character=='*'
  }

  def notPreviousStep(row: Int, column: Int, pRow: Int, pColumn: Int): Boolean = {
    row!=pRow || column!=pColumn
  }

  def getPossibleMoves(matrix: Array[Array[Char]], row: Int, column: Int, pRow: Int, pColumn: Int): List[Move] = {
    val moves= new ListBuffer[Move]
    if(row!=0 && possibleMove(matrix,row-1,column) && notPreviousStep(row-1,column,pRow,pColumn)){
      moves.+=(Move(row-1,column))
    }
    if(row!=matrix.size-1 && possibleMove(matrix,row+1,column) && notPreviousStep(row+1,column,pRow,pColumn)){
      moves.+=(Move(row+1,column))
    }
    if(column!=0 && possibleMove(matrix,row,column-1) && notPreviousStep(row,column-1,pRow,pColumn)){
      moves.+=(Move(row,column-1))
    }
    if(column!=matrix(row).size-1 && possibleMove(matrix,row,column+1) && notPreviousStep(row,column+1,pRow,pColumn)){
      moves.+=(Move(row,column+1))
    }
    moves.toList
  }
}
case class Move(row:Int,column:Int)