package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P13 (**) Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
 * Example:
 * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 *
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P13 {

  def encodeDirect(ls: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def _encodeDirect(i: Int, result: List[(Int, Symbol)], current: List[Symbol]): List[(Int, Symbol)] = current match {
      case Nil => result
      case h :: sec :: tail if (h == sec) => _encodeDirect(i + 1, result, sec :: tail)
      case h :: sec :: tail if (h != sec) => _encodeDirect(1, result ::: List((i, h)), sec :: tail)
      case h :: Nil => _encodeDirect(1, result ::: List((i, h)), Nil)
    }

    _encodeDirect(1, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    val r = encodeDirect(l)
    println(r)
  }

}