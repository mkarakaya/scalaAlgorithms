package hackerrank.search

/**
  * Created by mokarakaya on 10.10.2016.
  */
object BinarySearch {

  def binarySearch(arr: Array[Int], search: Int,low:Int,high:Int):Int = {
    if(low>high) -1
    else{
      val index=(low+high)/2
      if(arr(index)==search) index
      else if(arr(index)>search) binarySearch(arr,search,low,index-1)
      else binarySearch(arr,search,index+1,high)
    }
  }

  def main(args: Array[String]) {
    //val arr : Array[Int]= Array(9,19,81,12,6,13,25,4,15,7,1,3,25,19,10,81,2,1,2)
    val arr : Array[Int]= Array(2,3,4,5,7)
    val index=binarySearch(arr,6,0,arr.length-1)
    print(index)
  }

}
