package hackerrank.search

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * https://www.hackerrank.com/challenges/cut-the-tree
  * Created by mokarakaya on 07.10.2016.
  */
object CutTheTree {

  def getWeights(nodes: List[Node]): Unit = {
    nodes.foreach(node =>{
      node.edges.foreach(edge=>{
        //calculateSubtree()
      })
    })

  }

  def main(args: Array[String]) {
    val numberOfNodes=StdIn.readLine().toInt
    val nodesString=StdIn.readLine().split(" ")
    val nodes=nodesString.map(number => new Node(number.toInt,new ListBuffer[Edge],false))
    val sum= nodesString.map(_.toInt).sum
    for(i <- 1 to numberOfNodes-1){
      val arr=StdIn.readLine().split(" ").map(_.toInt)
      nodes(arr(0)-1).edges+=new Edge(nodes(arr(1)-1),0,0)
      nodes(arr(1)-1).edges+=new Edge(nodes(arr(0)-1),0,0)
    }
    //getWeights(nodes)

  }
}
case class Node(value:Int, edges:ListBuffer[Edge], var visited:Boolean)
case class Edge(neighbor:Node, var from:Int, var to:Int)
