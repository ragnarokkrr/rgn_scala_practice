package org.rgn.scala.art.ch06

object UserInput {

  def sumInputsInts(num: Int): Int = {
    if (num > 0) {
      readInt() + sumInputsInts(num - 1)
    } else {
      0
    }
  }

  def sumInputsPositives(): Int = {
    val n = readInt()
    if (n > 0) {
      n + sumInputsPositives()
    } else {
      0
    }
  }

  def sumUntilQuit(): Int = {
    val n = readLine()
    if (n != "quit") {
      n.toInt + sumUntilQuit
    } else {
      0
    }

  }

  def sumAndCount(): (Int, Int) = {
    val n = readLine()
    if (n != "quit") {
      val (s, c) = sumAndCount()
      (s + n.toInt, c + 1)
    } else {
      (0, 0)
    }

  }

  def averageInput(): Double = {
    val (sum, count) = sumAndCount()
    sum.toDouble / count
  }

  def main(args: Array[String]): Unit = {
    println("sumInputsInts")
    val s = sumInputsInts(3)
    println(s)

    println("sumInputsPositives")
    val sp = sumInputsPositives()
    println(sp)

    println("sumUntilQuit")
    val sq = sumUntilQuit
    println(sq)

    println("sumAndCount")
    val sc = sumAndCount()
    println(sc)

  }

}