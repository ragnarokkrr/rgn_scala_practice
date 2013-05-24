package org.rgn.scala.steps.ch03

abstract class LinkedList
case object EmptyList extends LinkedList
case class LNode(elem: Int, next: LinkedList ) extends LinkedList

object list {
  def main(args: Array[String]) {
    var l = LNode(10, LNode(20, LNode(30, LNode(40, EmptyList))))
    println(traverse(l))

    var l2 = mkList(5)
    println(traverse(l2))

    insert(51, 2, l2)
    println(traverse(l2))
  }

  def mkList(v: Int): LinkedList = {
    LNode(v, EmptyList)
  }

  def mkList(v: Int, l: LinkedList): LinkedList = {
    LNode(v, l)
  }

  def traverse(l: LinkedList): List[Int] = {
    l match {
      case EmptyList => List()
      //case LNode(v, EmptyList) => List(v)
      case LNode(v, n) => List(v) ::: traverse(n)
    }

  }

  def insert(v: Int, pos: Int, theList: LinkedList): Unit = {
    def ins(v: Int, p: Int, i: Int, l: LinkedList, prev: LinkedList): Unit = {
      (i, l, prev) match {
     //   case (p, _, _) => ins(v, p, i+1, next, l)
        case (_, LNode(_, next), _) => ins(v, p, i+1, next, l)
      }

    }

    theList match {
      //case EmptyList => mkList(v)
      case LNode(_, next) => ins(v, pos, 0, theList, theList)
    }
  }

}