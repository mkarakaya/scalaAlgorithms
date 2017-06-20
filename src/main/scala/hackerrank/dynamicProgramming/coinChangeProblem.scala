package hackerrank.dynamicProgramming

import scala.io.StdIn

/**
  * https://www.hackerrank.com/challenges/coin-change
  * Created by mokarakaya on 30.07.2016.
  */
object coinChangeProblem {

  def coinChange(x:Int, y:Int, arr: Array[Int], memo: Array[Array[BigInt]]): BigInt = {

    if(memo(y)(x)!= -1){
      return memo(y)(x)
    }
    if(x>=arr(y)){
      memo(y)(x)=coinChange(x,y-1,arr,memo)+coinChange(x-arr(y),y,arr,memo)
    }else{
      memo(y)(x)=coinChange(x,y-1,arr,memo)
    }
    memo(y)(x)
  }

  def main(args: Array[String]): Unit = {
    val input =StdIn.readLine().split(" ").map(_.toInt)
    val arr =StdIn.readLine().split(" ").map(_.toInt)
    var memo = Array.fill[BigInt](input(1),input(0)+1){-1}
    for ( i <- 0 to (memo.length-1 )) {
      memo(i)(0) = 1
    }
    for (j <- 0 to (memo(0).length - 1)) {
      memo(0)(j) = if (j % arr(0) == 0) 1 else 0
    }

    println(coinChange(input(0),input(1)-1,arr,memo))
  }
}
