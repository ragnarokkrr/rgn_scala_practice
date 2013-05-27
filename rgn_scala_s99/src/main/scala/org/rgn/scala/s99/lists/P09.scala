package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * Example:
 * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 *
 * @author ragnarokkrr
 *
 */
class P09
object P09 {

  def pack(ls: List[Symbol]): List[List[Symbol]] = {
    @tailrec
    def _group(result: List[Symbol], group: List[Symbol], current: List[Symbol]): (List[Symbol], List[Symbol]) = group match {
      case Nil => (result, current)
      case h :: hh :: tail if (h == hh) =>
        _group(result ::: List(h), hh :: tail, hh :: tail)
      case h :: hh :: tail if (h != hh) =>//stop condition for group list
        _group(result ::: List(h), Nil, hh :: tail)
      case h :: Nil => //stop condition for entire list
        _group(result ::: List(h), Nil, Nil)
    }

    @tailrec
    def _pack(result: List[List[Symbol]], current: List[Symbol]): List[List[Symbol]] = current match {
      case Nil => result
      case _ =>
        val group = _group(Nil, current, current)
        println(group)
        _pack(result ::: List(group._1), group._2)
    }

    _pack(List(), ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val r = pack(l)
    println(r)

    //val r = _group(Nil, l)
    //println(r)
  }

}