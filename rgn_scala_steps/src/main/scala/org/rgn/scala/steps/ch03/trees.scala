package org.rgn.scala.steps.ch03

abstract class BinTree
case object EmptyTree extends BinTree
case class Node(Elem: Int, left: BinTree, ritght: BinTree) extends BinTree

object trees {

  def main(args: Array[String]) {
    println("trees")
    //testTreeOneNode
    //testTraversal
    //testOrdering
    testReflect
  }

  def testReflect:Unit ={
    	var t = Node(5
    			,Node(3
    			    , EmptyTree
    			    ,Node(4, EmptyTree, EmptyTree))
    			, Node(7, EmptyTree, EmptyTree))
    			
    	println(inOrder(t))
    	var t1 = reflect(t)
    	println(inOrder(t1))
    
  }
  
  def testOrdering: Unit = {
    println("testOrdering")
    
    val in = readIntList
    println("Numbers read =>")
    println(in)
    
    var t = mkTree(in)
    
    println(inOrder(t))
    
  }
  
  def mkTree(l:List[Int]): BinTree ={
    def insert(x:Int, t:BinTree): BinTree ={
      t match {
        case EmptyTree => Node(x, EmptyTree, EmptyTree)
        case Node(y, l, r) =>
          if (x<y)
            Node (y,insert(x,l), r)
          else if (x>y)
            Node(y, l, insert(x, r))
          else
            EmptyTree
      }
    }//end of insert
    l match{
      case Nil => EmptyTree
      case head::tail => insert(head, mkTree(tail))
    }
  }
  
  def reflect(t: BinTree): BinTree ={
    t match{
      case null => EmptyTree
      case Node (x, l, r) => Node(x, r, l)
    }
   }
  
  /**
   * @param t A tree
   * @return A traverse tree
   */
  def inOrder(t: BinTree): List[Int] =
    t match {
      case EmptyTree => List()
      case Node(e, l, r) => inOrder(l) ::: List(e) ::: inOrder(r)
    }

  def preOrder(t: BinTree): List[Int] =
    t match {
      case EmptyTree => List()
      case Node(e, l, r) => List(e) ::: preOrder(l) ::: preOrder(r)

    }

  def postOrder(t: BinTree): List[Int] =
    t match {
      case EmptyTree => List()
      case Node(e, l, r) => postOrder(l) ::: postOrder(r) ::: List(e)
    }

  def depth(t: BinTree): Int = {
    t match {
      case EmptyTree => 0
      case Node(_, EmptyTree, r) => 1 + depth(r)
      case Node(_, l, EmptyTree) => 1 + depth(l)
      case Node(_, l, r) => scala.math.max(depth(l), depth(r)) + 1
    }
  }

  private def testTreeOneNode: Unit = {

    var t1 = EmptyTree
    var t2 = Node(4, EmptyTree, EmptyTree)

    println("t2: " + inOrder(t2))
  }

  private def testTraversal: Unit = {

    var t3 = Node(6, Node(5, Node(4, EmptyTree, EmptyTree), EmptyTree), Node(9, EmptyTree, EmptyTree))

    println("t3 - in: " + inOrder(t3))
    println("t3 - pre: " + preOrder(t3))
    println("t3 - post: " + postOrder(t3))
    println("t3 - depth: " + depth(t3))
  }
  
  private def readIntList: List[Int] = {
    var EOF = false
    var x:Int = 0
    var in:List[Int] = List()
    do{
      print ("Enter a number: ")
      try{
        x = readInt()
        readLine()
      }catch{
        case eof: java.io.IOException => EOF = !EOF
        case numFormat: java.lang.NumberFormatException => EOF = !EOF
      }
      if(!EOF){
        in = x ::in
      }
      
    }while(!EOF)
    in
  }

}



