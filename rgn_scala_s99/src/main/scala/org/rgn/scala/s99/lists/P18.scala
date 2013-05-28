package org.rgn.scala.s99.lists

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P18 (**) Extract a slice from a list.
 * Given two indices, I and K, the slice is the list containing the elements from
 * and including the Ith element up to but not including the Kth element of the
 * original list. Start counting the elements with 0.
 *
 * Example:
 *
 * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('d, 'e, 'f, 'g)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P18 {

  def slice(i: Int, k: Int, ls: List[Symbol]): List[Symbol] = {
    def _slice(j: Int, result: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result
      case _ if (j >= k) => _slice(j + 1, result, Nil) //forces stop after k
      case h :: tail if (j >= i && j < k) => _slice(j + 1, result ::: List(h), tail)
      case h :: tail => _slice(j + 1, result, tail)
    }
    _slice(0, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val r = slice(3, 7, l)
    println(r)

  }

}