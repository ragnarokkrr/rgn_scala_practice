package org.rgn.scala.s99.lists

import scala.annotation.tailrec

/**
 *  S-99: Ninety-Nine Scala Problems
 * 
 * P12 (**) Decode a run-length encoded list.
 * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
 * Example:
 * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 * 
 * @author Nilseu Padilha	ragnarokkrr.blog@gmail.com
 *
 */
class P12
object P12 {
  
  def decode(ls: List[(Int, Symbol)]): List[Symbol]={
    
    def _explode(tuple:(Int,Symbol)): List[Symbol] = {
      @tailrec
      def __explode(result: List[Symbol], i:Int): List[Symbol] = i match{
        case 0 => result
        case _ => __explode(result ::: List(tuple._2), i-1)
      }
      
      __explode(Nil, tuple._1)
    }
    
    @tailrec
    def _decode(result: List[Symbol], current: List[(Int, Symbol)]): List[Symbol] = current match{
      case Nil => result
      case h:: tail => _decode(result ::: _explode(h), tail)
    }
    
    _decode(Nil, ls)
  }
  def main(args: Array[String]) {

    val l = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val r = decode(l)
    
    println(l)
    println(r)
  }
}