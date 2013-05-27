package org.rgn.scala.s99.lists

import org.scalatest.matchers.ShouldMatchers
import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P05 (*) Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 *
 *  @author ragnarokkrr
 *
 */
class P05
object P05 extends ShouldMatchers {

  def reverse(ls: List[Int]): List[Int] = ls match {
    case h :: tail => reverse(tail) ::: List(h)
    case Nil => Nil
  }

  def reverseTail(ls: List[Int]): List[Int] = {
    @tailrec
    def rev(i: Int, result: List[Int], current: List[Int]): List[Int] = current match {
      case Nil => result
      case h :: tail =>
        printf("test[%d]: %22s - %22s\n", i, result, current)
        rev(i + 1, List(h) ::: result, tail)
    }

    rev(0, List(), ls)
  }

  def main(args: Array[String]) {

    val l = List(1, 1, 2, 3, 5, 8)
    val r = reverse(l)
    val expected = List(8, 5, 3, 2, 1, 1)
    //println(r)

    r should be(expected)



    val r2 = reverseTail(l)
    println("r2: " + r2)
    r2 should be(expected)
  }

}