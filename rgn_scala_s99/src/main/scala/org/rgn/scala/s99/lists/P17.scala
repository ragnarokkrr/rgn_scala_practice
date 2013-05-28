package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 * 
 * P17 (*) Split a list into two parts.
 * The length of the first part is given. Use a Tuple for your result.
 * Example:
 *
 * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P17 {

  def split(n: Int, ls: List[Symbol]): (List[Symbol], List[Symbol]) = {
    @tailrec
    def _split(i: Int, result: (List[Symbol], List[Symbol]), current: List[Symbol]): (List[Symbol], List[Symbol]) = current match {
      case Nil => result
      case h :: tail if (i <= n) => _split(i + 1, (result._1 ::: List(h), result._2), tail)
      case h :: tail => _split(i + 1, (result._1, result._2 ::: List(h)), tail)
    }
    _split(1, (Nil, Nil), ls)
  }
  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val r = split(3, l)
    println(r)
  }

}