package org.rgn.scala.s99.lists

import org.scalatest.matchers.ShouldMatchers
import scala.annotation.tailrec

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P07 (**) Flatten a nested list structure.
 * Example:
 * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 *
 * @author ragnarokkrr
 *
 */
class P07
object P07 extends ShouldMatchers {

  
  def flatten(ls: List[Any]): List[Any] = {
    @tailrec
    def _flat(result: List[Any], current: List[Any]): List[Any] = current match {
      case Nil => result
      case h :: tail if (h.isInstanceOf[List[Any]]) =>
        _flat(result ::: flatten(h.asInstanceOf[List[Any]]), tail)
      case h :: tail => _flat(result ::: List(h), tail)
    }
    _flat(Nil, ls)
  }


  
  def main(args: Array[String]): Unit = {
    val l = List(List(1, 1), 2, List(3, List(5, 8)))
    val r = flatten(l)
    print(r)
    r should be(List(1,1,2,3,5,8))
  }

}