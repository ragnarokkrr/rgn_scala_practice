package org.rgn.scala.s99.lists

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P11 (*) Modified run-length encoding.
 * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
 * Example:
 * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 *
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P11 {
  import P09.pack

  def encodeModified(ls: List[Symbol]): List[Any] = {
    def _encodeModified(result: List[Any], current: List[List[Symbol]]): List[Any] = current match {
      case Nil => result
      case h :: tail if (h.size > 1) => 
        _encodeModified(result ::: List((h.size, h.head)), tail)
      case h :: tail => 
        _encodeModified(result ::: List(h.head), tail)
    }

    _encodeModified(Nil, pack(ls))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val r = encodeModified(l)

    println(r)

  }

}