package hackerrank.graphTheory

/**
  * Created by mokarakaya on 01.10.2016.
  */
object BinaryTree {
  def main(args: Array[String]): Unit = {
    var root= NodeBT(6,null,null,null)
    val nodeB= NodeBT(5,null,null,null)
    val nodeC= NodeBT(10,null,null,null)
    val nodeD= NodeBT(2,null,null,null)
    val nodeE= NodeBT(5,null,null,null)
    val nodeF= NodeBT(12,null,null,null)
    val nodeG= NodeBT(8,nodeC,null,null)
    val nodeH= NodeBT(7,nodeG,null,null)
    val nodeI= NodeBT(9,nodeG,null,null)
    nodeC.right=nodeF
    nodeC.left=nodeG
    nodeF.parent=nodeC
    root.right=nodeC
    nodeC.parent=root
    nodeB.right=nodeE
    nodeE.parent=nodeB
    nodeB.left=nodeD
    nodeD.parent=nodeB
    root.left=nodeB
    nodeB.parent=root
    nodeG.left=nodeH
    nodeG.right=nodeI
    //inorderTreeWalk(root)

    //println(treeSearch(root,8).value)

    //println(treeSuccessor(root).value)

    //root=treeInsert(root,NodeBT(6,null,null,null))

    treeDelete(root,root)
    println(root.value)
  }
  def treeDelete(root:NodeBT,node:NodeBT): Unit ={
    if(node.left==null) transplant(root,node,node.right)
    else if(node.right==null) transplant(root,node,node.left)
    else{
      val min=treeMin(node.right)
      if(min.parent!=node){
        transplant(root,min,min.right)
        min.right=node.right
        min.right.parent=min
      }
      transplant(root,node,min)
      min.left=node.left
      min.left.parent=min
    }

  }
  def transplant(root:NodeBT,firstNode:NodeBT,secondNode:NodeBT): NodeBT ={
    if(firstNode.parent==null) return secondNode
    if(firstNode.parent.left==firstNode)firstNode.parent.left=secondNode
    else firstNode.parent.right=secondNode
    secondNode.parent=firstNode.parent
    root
  }
  def inorderTreeWalk(node:NodeBT){
    if(node==null) return
    inorderTreeWalk(node.left)
    println(node.value)
    inorderTreeWalk(node.right)
  }
  def treeInsert(root:NodeBT,node:NodeBT): NodeBT ={
    var x:NodeBT=root
    var y:NodeBT=null
    while(x!=null) {
      y = x
      if (node.value < x.value) x = x.left else x = x.right
    }
    node.parent=y
    if(y==null){
      return node
    }else if(node.value<y.value){
      y.left=node
    }else y.right=node
    root
  }
  def treeSearch(node:NodeBT,value:Int): NodeBT ={
    if(node==null || node.value==value) return node
    if (node.value>value) treeSearch(node.left,value) else treeSearch(node.right, value)
  }

  def treeMin(node: NodeBT): NodeBT ={
    if(node.left!=null) return treeMin(node.left)
    node
  }

  def treeSuccessor(node: NodeBT): NodeBT ={
    if(node.right!=null){
      treeMin(node.right)
    }else{
      var returnNode:NodeBT = node.parent
      var nodeBT:NodeBT = node
      while(returnNode!=null && returnNode.right.value==nodeBT.value){
        nodeBT=returnNode
        returnNode=returnNode.parent
      }
      returnNode
    }
  }
}

case class  NodeBT(value:Int,var right:NodeBT,var left:NodeBT, var parent:NodeBT){
}
