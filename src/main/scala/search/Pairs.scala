package search

import scala.io.StdIn

/**
  * https://www.hackerrank.com/challenges/pairs
  * Created by mokarakaya on 06.10.2016.
  */
object Pairs {

  def pairs(i: Int, j:Int,count:Int, goalSum: Int, arr: Array[Int]) : Int = {
    if (i == arr.length || j == arr.length) count
    else {
      val diff = arr(j) - arr(i)
      if (diff == goalSum) {
        pairs(i, j + 1, count + 1, goalSum, arr)
      } else if (diff < goalSum) {
        pairs(i, j + 1, count, goalSum, arr)
      } else {
        pairs(i + 1, j, count, goalSum, arr)
      }
    }
  }

  def main(args: Array[String]) {
    val input=StdIn.readLine().split(" ").map(_.toInt)
    val arr=StdIn.readLine().split(" ").map(_.toInt)
    val result= pairs(0,1,0,input(1),arr.sortWith(_<_))
    print(result)
  }

}
