package org.rgn.scala.s99.lists

import scala.util.Random

/**
 *
 * S-99: Ninety-Nine Scala Problems
 *
 * P23 (**) Extract a given number of randomly selected elements from a list.
 * Example:
 * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 * res0: List[Symbol] = List('e, 'd, 'a)
 * Hint: Use the solution to problem P20
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P23 {

  def randomSelect(n: Int, ls: List[Symbol]): List[Symbol] = {
    def _randomSelect(i: Int, result: List[Symbol], current: List[Symbol]): List[Symbol] = i match {
      case 0 => result
      case _ =>
        val toGo = P20.removeAt(new Random().nextInt(ls.size), current)._2
        _randomSelect(i - 1, result ::: List(toGo), current)
    }
    _randomSelect(n, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    val r = randomSelect(3, l)
    println(r)
    println(l)

  }

}