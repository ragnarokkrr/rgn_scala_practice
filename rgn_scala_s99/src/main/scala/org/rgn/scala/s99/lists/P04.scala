package org.rgn.scala.s99.lists

import org.scalatest.matchers.ShouldMatchers

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P04 (*) Find the number of elements of a list.
 * Example:
 * scala> length(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 6
 *
 * @author ragnarokkrr
 *
 */
class P04
object P04 extends ShouldMatchers {
  def length(ls: List[Int]): Int = ls match {
    case _ :: tail => 1 + length(tail)
    case Nil => 0
  }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)

    val res = length(l)

    res should be(6)
    println(res)
  }
}