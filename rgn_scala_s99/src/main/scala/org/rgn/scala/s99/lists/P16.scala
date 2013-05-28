package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P16 (**) Drop every Nth element from a list.
 * Example:
 * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P16 {

  def drop(i: Int, ls: List[Symbol]): List[Symbol] = {
    @tailrec
    def _drop(j: Int, result: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result
      case _ :: tail if (j % i == 0) => _drop(j + 1, result, tail)
      case h :: tail => _drop(j + 1, result ::: List(h), tail)
    }
    _drop(1, Nil, ls)
  }

  def main(args: Array[String]) {
    val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val r = drop(3, l)
    println(r)
  }
}