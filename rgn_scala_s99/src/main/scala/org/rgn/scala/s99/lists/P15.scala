package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 * 
 * 
 * P15 (**) Duplicate the elements of a list a given number of times.
 * Example:
 * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
 * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P15 {

  def duplicateN(i: Int, ls: List[Symbol]): List[Symbol] = {
    @tailrec
    def _duplicateN(j: Int, result: List[Symbol], current: List[Symbol]): List[Symbol] = (j, current) match {
      case (_, Nil) => result
      case (jj, h :: tail) if (jj > 1) => _duplicateN(j - 1, result ::: List(h), h :: tail)
      case (jj, h :: tail) if (jj == 1) => _duplicateN(i, result ::: List(h), tail)
    }
    _duplicateN(i, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'c, 'd)
    val r = duplicateN(3, l)
    println(r)
  }

}