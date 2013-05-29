package org.rgn.scala.s99.lists

/**
 * S-99: Ninety-Nine Scala Problems
 *
 * P20 (*) Remove the Kth element from a list.
 * Return the list and the removed element in a Tuple. Elements are numbered from 0.
 * Example:
 *
 * scala> removeAt(1, List('a, 'b, 'c, 'd))
 * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 *
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
object P20 {

  def removeAt(i: Int, ls: List[Symbol]): (List[Symbol], Symbol) = {
    def _removeAt(j: Int, sym: Symbol, result: List[Symbol], current: List[Symbol]): (List[Symbol], Symbol) = current match {
      case Nil => (result, sym)
      case h :: tail if (i == j) => _removeAt(j + 1, h, result, tail)
      case h :: tail => _removeAt(j + 1, sym, result ::: List(h), tail)
    }
    _removeAt(0, 'notfound, Nil, ls)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a, 'b, 'c, 'd)
    val r = removeAt(1, l)
    println(r)
  }

}