package sorting

/**
  * Created by mokarakaya on 09.10.2016.
  */
object HeapSort {

  def heapSort(arr: Array[Int],heapLength:Int): Array[Int] = {
    if(heapLength==1)arr
    else {
      buildMaxHeap(arr, heapLength,if(heapLength-1%2==0) (heapLength-3)/2 else (heapLength-2)/2)
      swap(0, heapLength - 1, arr)
      heapSort(arr, heapLength - 1)
    }
  }

  def buildMaxHeap(arr: Array[Int],heapLength:Int,parent:Int): Array[Int]= {
    if (parent == -1) arr
    else {
      var rightChild = 2 * parent + 1
      if (rightChild >= heapLength) rightChild = parent
      var leftChild = 2 * parent + 2
      if (leftChild >= heapLength) leftChild = parent
      val compare = if (arr(rightChild) > arr(leftChild)) rightChild else leftChild
      if (arr(parent) < arr(compare)) swap(parent, compare, arr)
      buildMaxHeap(arr, heapLength, parent - 1)
    }
  }
  def swap(parent: Int, compare: Int, arr: Array[Int]) = {
    val parentValue=arr(parent)
    arr(parent)=arr(compare)
    arr(compare)=parentValue
  }
  def main(args: Array[String]) {
    //val arr : Array[Int]= Array(9,19,81,12,6,13,25,4,15,7,1,3,25,19,10,81,2,1,2)
    val arr : Array[Int]= Array(1,3,5,7)
    heapSort(arr,arr.length)
    arr.foreach(i=> print(i +","))
  }

}
