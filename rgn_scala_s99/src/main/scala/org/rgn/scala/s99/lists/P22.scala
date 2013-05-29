package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 *
 * P22 (*) Create a list containing all integers within a given range.
 * Example:
 * scala> range(4, 9)
 * res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P22 {

  def range(lb: Int, ub: Int): List[Int] = {
    @tailrec
    def _range(i: Int, result: List[Int]): List[Int] = i match {
      case i if (i > ub) => result
      case _ => _range(i + 1, result ::: List(i))
    }
    _range(lb, Nil)
  }

  def main(args: Array[String]) {
    val r = range(4, 9)
    println(r)
  }

}