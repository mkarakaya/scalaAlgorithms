package hackerrank.sorting

/**
  * Created by mokarakaya on 09.10.2016.
  */
object Quicksort {

  def quicksort(arr: Array[Int], low: Int, high: Int) : Array[Int]={
    if(low<high){
      val p = sortPartition(arr,low,high)
      quicksort(arr,low,p-1 )
      quicksort(arr,p+1,high)
    }
    arr
  }
  def sortPartition(arr: Array[Int], low: Int, high: Int) : Int= {
    val pivot= arr(high)
    var i= low
    var j= low
    while(j!=high){
      if(arr(j) <= pivot){
        swap(j,i,arr)
        i+=1
      }
      j+=1
    }
    swap(i,high,arr)
    i
  }
  def swap(parent: Int, compare: Int, arr: Array[Int]) = {
    val parentValue=arr(parent)
    arr(parent)=arr(compare)
    arr(compare)=parentValue
  }
  def main(args: Array[String]) {
    //val arr : Array[Int]= Array(9,19,81,12,6,13,25,4,15,7,1,3,25,19,10,81,2,1,2)
    val arr : Array[Int]= Array(3,2,4,7,5)
    quicksort(arr,0,arr.length-1)
    arr.foreach(i=> print(i +","))
  }
}
