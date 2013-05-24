package org.rgn.scala.s99.lists

import org.scalatest.matchers.ShouldMatchers

/**
 * S-99: Ninety-Nine Scala Problems
 * 
 * P02 (*) Find the last but one element of a list.
 * Example:
 * <code>
 * scala> penultimate(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 5
 * </code>
 * @author ragnarokkrr
 *
 */
class P02
object P02 extends ShouldMatchers {

  def penultimate(l: List[Int]): Int = l match {
    case _ :: pen :: _ :: Nil => pen
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    val res = penultimate(l)
    res should be(5)
    println(5)

  }

}