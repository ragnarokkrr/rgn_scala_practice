package org.rgn.scala.s99.lists

//import org.scalatest.matchers.ShouldMatchers

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * p01 - Find the last element of a list. Example:
 * <code>
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 * </code>
 *
 * @author ragnarokkrr
 *
 */
class P01
object P01 /*extends ShouldMatchers */{

  def last(l: List[Int]): Int = l match {
    case h :: Nil => h
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }

  def main(args: Array[String]) {

    val ls = List(1, 1, 2, 3, 5, 8)
    val lastVal = last(ls)
    println(lastVal)
//    lastVal should be(8)
  }
}