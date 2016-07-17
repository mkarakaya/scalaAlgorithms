package functionalStructures

import java.util

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by 212457624 on 17.07.2016.
  */
object PrisonTransport {

  def getCost(person: Person, cost: Int,arr :Array[Person]): Int = {
    var costUpdated=cost+1
    person.visited=true
    for(neighbor<- person.list){
      if(!arr(neighbor).visited){
        costUpdated=getCost(arr(neighbor),costUpdated,arr)
      }
    }
    costUpdated
  }

  def main(args: Array[String]): Unit = {
    val size= StdIn.readInt()
    val arr= new Array[Person](size+1)
    val cuffedTogether= StdIn.readInt()
    1 to cuffedTogether foreach { _ =>
      var list =StdIn.readLine().split(" ").map(_.toInt)
      for(i <- list){
        if(arr(i)==null){
          arr(i)=new Person(i)
        }
      }
      var firstPerson= arr(list(0))
      var secondPerson=arr(list(1))
      firstPerson.list+=secondPerson.index
      secondPerson.list+=firstPerson.index
    }
    var cost=0
    for ( i <- 1 to (arr.length - 1)) {
      if(arr(i)==null){
        cost+=1
      }else if(!arr(i).visited){
        val add=getCost(arr(i),0,arr)
        var pcost=Math.sqrt(add)
        if(pcost>pcost.toInt) {
          pcost = pcost.toInt + 1
        }
          cost+= pcost.toInt
      }
    }
    print(cost)
  }
}
class Person(indexc: Int) {
  var index: Int = indexc
  var visited: Boolean=false
  var list: mutable.MutableList[Int]=mutable.MutableList()
}
