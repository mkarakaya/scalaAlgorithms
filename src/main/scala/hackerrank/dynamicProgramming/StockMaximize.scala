package hackerrank.dynamicProgramming

import scala.io.StdIn

/**
  * https://www.hackerrank.com/challenges/stockmax
  * Created by mokarakaya on 31.07.2016.
  */
object StockMaximize {
  def main(args: Array[String]): Unit = {
    val tests = StdIn.readInt();
    1 to tests foreach { _ =>
      val size = StdIn.readInt();
      val arr = StdIn.readLine().split(" ").map(_.toInt)
      var profit = BigInt (0)
      var max =  0
      for (i <- arr.length - 1 to 0 by -1) {
        if (arr(i) >= max) {
          max = arr(i)
        }
        profit += max - arr(i)
      }
      println(profit)
    }
  }
}
