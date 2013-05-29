package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P21 (*) Insert an element at a given position into a list.
 * Example:
 * scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
 * res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P21 {
  def insertAt(newSym: Symbol, pos: Int, ls: List[Symbol]): List[Symbol] = {
	@tailrec
    def _insertAt(i: Int, result: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result
      case h :: tail if (i == pos) => _insertAt(i + 1, result ::: List(newSym) ::: List(h), tail)
      case h :: tail => _insertAt(i + 1, result ::: List(h), tail)
    }

    _insertAt(0, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd)
    val r = insertAt('new, 1, l)
    println(r)
  }

}