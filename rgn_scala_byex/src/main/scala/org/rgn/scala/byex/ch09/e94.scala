package org.rgn.scala.byex.ch09

import scala.annotation.tailrec

object e94 {

  object Scale {
    def scaleList(l: List[Double], factor: Double): List[Double] = l match {
      case Nil => l
      case h :: t => h * factor :: scaleList(t, factor)
    }

    @tailrec
    def scaleListTail(l: List[Double], factor: Double, r: List[Double] = Nil): List[Double] = l match {
      case Nil => r
      case h :: t => scaleListTail(t, factor, r ::: List(h * factor))
    }

    def scaleListMap(l: List[Double], factor: Double): List[Double] =
      l map (x => x * factor)

    def column[A](l: List[List[A]], index: Int): List[A] =
      l map (row => row(index))

    /*
    def foreachz[List[_]](f: List[_] =>Unit) {
      this match{
        case Nil => ()
        case h::t => f(h); t.foreachz(f)
      }
    }
    */
    @tailrec
    def squareList(l: List[Int], r: List[Int] = Nil): List[Int] = l match {
      case Nil => r
      case h :: t => squareList(t, r ::: List(h * h))
    }
    def squareListMap(l: List[Int]): List[Int] =
      l map (x => x * x)

    def test() {
      println("Scale - Nontail")
      val l = List(10., 20, 30, 40)
      val r = scaleList(l, 10.)
      println(r)

      println("Scale - Tail")
      val r1 = scaleListTail(l, 20.)
      println(r1)

      println("Scale - Map")
      val r2 = scaleListTail(l, 20.)
      println(r2)

      println("List matrix map")
      val m = List(List('aa, 'ab, 'ac), List('ba, 'bb, 'bc), List('ca, 'cb, 'cc))

      val r3 = column(m, 2)
      println(r3)

      println("Lisr squarList")
      val l2 = List(1, 2, 3, 4)
      val r4 = squareList(l2)
      println(r4)

      println("Lisr squareList")
      val r5 = squareListMap(l2)
      println(r5)

    }
  }
  
  object FilterList{
    //def posElems(l: LI)
    
  }

  def main(args: Array[String]): Unit = {
    Scale.test

  }

}