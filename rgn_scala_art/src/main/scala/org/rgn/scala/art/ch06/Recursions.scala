package org.rgn.scala.art.ch06

import scala.annotation.tailrec

object Recursions {

  def fact(n: Int): Int =
    if (n < 2) 1
    else n * fact(n - 1)

  @tailrec
  def factTail(n: Int, f: Int = 1): Int =
    if (n < 2) f
    else factTail(n - 1, n * f)

  @tailrec
  def countDown(n: Int) {
    if (n >= 0) {
      println(n)
      countDown(n - 1)
    }
  }
  @tailrec
  def countFromTo(from: Int, to: Int) {
    println(from)
    if (from != to) {
      countFromTo(from + 1, to)
    }
  }

  @tailrec
  def countFromToAnyOrder(from: Int, to: Int) {
    println(from)
    if (from != to) {
      countFromToAnyOrder(from + (if (from < to) 1 else -1), to)
    }
  }

  def main(args: Array[String]): Unit = {
    println("fact")
    val f = fact(5)
    println(f)
    val ft = factTail(5)
    println(ft)

    println("countDown")
    countDown(5)
    println("countFromTo")
    countFromTo(5, 10)
    println("countFromToAnyOrder")
    countFromToAnyOrder(5, 10)
    println("countFromToAnyOrder")
    countFromToAnyOrder(10, 5)

  }

}