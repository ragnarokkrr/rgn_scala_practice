package org.rgn.scala.s99.lists

import org.scalatest.matchers.ShouldMatchers

/**
 * S-99: Ninety-Nine Scala Problems
 * 
 * P03 (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 * Example:
 * scala> nth(2, List(1, 1, 2, 3, 5, 8))
 * res0: Int = 2
 *
 * @author ragnarokkrr
 *
 */
class P03
object P03 extends ShouldMatchers {

  def nth(n: Int, ls: List[Int]): Int = (n, ls) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  def main(args: Array[String]) {
	  val ls = List(1, 1, 2, 3, 5, 8)
	  val res = nth(2, ls)
	  
	  println (res)
	  res should be(2)
	  
  }
}