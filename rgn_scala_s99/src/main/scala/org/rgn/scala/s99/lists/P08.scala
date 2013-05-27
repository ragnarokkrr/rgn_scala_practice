package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P08 (**) Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
 * Example:
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 * @author ragnarokkrr
 *
 */
class P08
object P08 {

  def compress(ls: List[Symbol]): List[Symbol] = {
    @tailrec
    def _compress(result: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result
      case h :: hh :: tail if (h != hh) =>
        printf("DIF: %28s %s\n", result ::: List(h), hh :: tail);
        _compress(result ::: List(h), hh :: tail)
      case h :: Nil =>
        printf("NIL: %28s %s\n", result, Nil);
        _compress(result ::: List(h), Nil)
      case _ :: tail =>
        printf("EQU: %28s %s\n", result, tail);
        _compress(result, tail)
    }

    _compress(Nil, ls)
  }
  def main(args: Array[String]): Unit = {

    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    val r = compress(l)
    println(r)
  }
}