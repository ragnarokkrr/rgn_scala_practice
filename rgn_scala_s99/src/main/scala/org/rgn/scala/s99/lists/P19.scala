package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P19 (**) Rotate a list N places to the left.
 * Examples:
 * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
 *
 * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P19 {

  def rotate(n: Int, ls: List[Symbol]): List[Symbol] = {
    @tailrec
    def _rotateLeft(i: Int, result: List[Symbol], slice: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result ::: slice
      case h :: tail if (i <= n) => _rotateLeft(i + 1, result, slice ::: List(h), tail)
      case h :: tail if (i > n) => _rotateLeft(i + 1, result ::: List(h), slice, tail)
      case h :: Nil => _rotateLeft(i + 1, result ::: List(h), slice, Nil)
    }

    @tailrec
    def _rotateRight(i: Int, result: List[Symbol], slice: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => slice ::: result
      case h :: tail if (i >= ls.size + n) =>
        _rotateRight(i + 1, result, slice ::: List(h), tail)
      case h :: tail if (i < ls.size + n) =>
        _rotateRight(i + 1, result ::: List(h), slice, tail)
      case h :: Nil => _rotateRight(i + 1, result, slice, Nil)
    }

    if (n > 0) {
      _rotateLeft(1, Nil, Nil, ls)
    } else if (n < 0) {
      _rotateRight(1, Nil, Nil, ls)
    } else {
      ls
    }
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    val r1 = rotate(3, l)
    println(r1)
    val r2 = rotate(-2, l)
    println(r2)
  }

}