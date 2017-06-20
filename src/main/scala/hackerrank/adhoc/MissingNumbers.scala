package hackerrank.adhoc

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by mokarakaya on 15.07.2016.
  */
object MissingNumbers {

  def main(args: Array[String]) {
    var firstList=readList(StdIn.readInt())
    var secondList=readList(StdIn.readInt())
    val arr= new Array[Int](200000)
    for ( i <- firstList) {
      arr(i)=  arr(i) - 1
    }
    for ( i <- secondList) {
      arr(i)=  arr(i) + 1
    }
    for ( i <- 0 to (arr.length - 1)) {
      if(arr(i)>0){
        print(i+" ")
      }
    }
  }
  def readList(size: Int)={
    StdIn.readLine().split(" ").map(_.toInt)
  }
}
