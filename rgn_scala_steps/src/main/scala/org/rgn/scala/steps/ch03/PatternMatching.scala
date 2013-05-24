package org.rgn.scala.steps.ch03

object PatternMatching {

  def main(args: Array[String]): Unit = {

    var t1 = Node(7, EmptyTree, EmptyTree)
    println("t1: " + isEmpty(t1))
    rootEl(t1)
    println("t1 constmatch: " + constMatch(t1))

    var t2 = EmptyTree
    println("t2: " + isEmpty(t2))
    rootEl(t2)
    println("t2 constmatch: " + constMatch(t2))

    
    
    
  }

  def constMatch(t: BinTree): Int =
    t match {
      case Node(3, _, _) => 3
      case Node(5, _, _) => 5
      case Node(7, _, _) => 7
      case Node(11, _, _) => 11
      case _ => -1
    }

  def rootEl(t: BinTree): Unit =
    t match {
      case Node(e, _, _) => println(e)
      case EmptyTree => println("empty tree!")
    }

  def isEmpty(t: BinTree): Boolean =
    t match {
      case EmptyTree => true
      case _ => false
    }

}