package org.rgn.scala.s99.lists

import scala.util.Random

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
 * Example:
 * scala> lotto(6, 49)
 * res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P24 {

  def lotto(n: Int, range: Int): List[Int] = {
    def _loto(i: Int, result: List[Int]): List[Int] = i match {
      case i if (i > n) => result
      case _ =>
        _loto(i + 1, result ::: List(new Random().nextInt(range)))
    }

    _loto(1, Nil)
  }

  def main(args: Array[String]): Unit = {
    val l = lotto(6, 49)
    println(l)
  }

}