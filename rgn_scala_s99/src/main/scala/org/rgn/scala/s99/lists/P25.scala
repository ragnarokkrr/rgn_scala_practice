package org.rgn.scala.s99.lists

import scala.annotation.tailrec
import scala.util.Random

/**
 *
 * S-99: Ninety-Nine Scala Problems
 *
 * P25 (*) Generate a random permutation of the elements of a list.
 * Hint: Use the solution of problem P23.
 * Example:
 *
 * scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 * res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P25 {

  def removeAt(n: Int, ls: List[Symbol]): (List[Symbol], Symbol) = {
    @tailrec
    def _removeAt(i: Int, rem: Symbol, res: List[Symbol], cur: List[Symbol]): (List[Symbol], Symbol) = cur match {
      case Nil => (res, rem)
      case h :: tail if (i == n) => _removeAt(i + 1, h, res, tail)
      case h :: tail => _removeAt(i + 1, rem, res ::: List(h), tail)
    }
    _removeAt(0, 'notfound, Nil, ls)
  }

  def randomPermute(ls: List[Symbol]): List[Symbol] = {
    @tailrec
    def _randomPermute(res: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => res
      case _ =>
        val rem = removeAt(new Random().nextInt(current.size), current)
        _randomPermute(res ::: List(rem._2), rem._1)
    }

    _randomPermute(Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd, 'e, 'f)
    val r = randomPermute(l)
    print (r)
  }

}