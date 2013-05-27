package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P06 (*) Find out whether a list is a palindrome.
 * Example:
 * scala> isPalindrome(List(1, 2, 3, 2, 1))
 * res0: Boolean = true
 *
 * @author ragnarokkrr
 *
 */
class P06
object P06 {

  def isPalindrome(ls: List[Int]): Boolean = {
    @tailrec
    def isPal(i: Int): Boolean = {
      if (ls(i) != ls(ls.length - i - 1)) return false
      if (i == ls.length / 2) return true
      isPal(i + 1)
    }

    isPal(0)
  }

  def main(args: Array[String]): Unit = {
    val g = List(1, 2, 3, 2, 1)
    val r = isPalindrome(g)
    println(r)

  }

}