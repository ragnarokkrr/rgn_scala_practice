package org.rgn.scala.s99.lists

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P14 (*) Duplicate the elements of a list.
 * Example:
 * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P14 {

  def duplicate(ls: List[Symbol]): List[Symbol] = {
    def _duplicate(result: List[Symbol], current: List[Symbol]): List[Symbol] = current match {
      case Nil => result
      case h::tail => _duplicate(result ::: List(h):::List(h), tail)
    }

    _duplicate(Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'c, 'd)
    val r = duplicate(l)

    println(r)

  }

}