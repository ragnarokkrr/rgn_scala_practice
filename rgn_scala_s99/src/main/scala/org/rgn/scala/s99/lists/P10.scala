package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P10 (*) Run-length encoding of a list.
 * Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
 * Example:
 * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 *
 * @author ragnarokkrr
 *
 */
class P10
object P10 {
  import P09.pack
  
  def encode(ls: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def _encode(result: List[(Int, Symbol)], current: List[List[Symbol]]): List[(Int, Symbol)] = current match {
      case Nil => result
      case h::tail => _encode(result ::: List((h.length, h.head)), tail)
    }

    val l = pack(ls)
    println(l)
    _encode(Nil, l)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val r = encode(l)
    println(r)
  }

}