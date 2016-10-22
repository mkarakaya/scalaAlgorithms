package introduction

import scala.collection.mutable.ListBuffer

/**
 * Created by mokarakaya on 12.07.2016.
 * https://www.hackerrank.com/challenges/fp-list-replication
 */
object ListReplication {

  def f(num:Int,arr:List[Int]):List[Int] = {
    var list= new ListBuffer[Int]
    for (number <- arr ){1 to num foreach { _ => list+=number }}
    list.toList
  }

  def main(args: Array[String]) {
    val nums: List[Int] = List(1, 2, 3, 4)
    var list=f(3,nums)
    list.foreach(println)

  }
}
