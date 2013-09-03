package org.rgn.scala.art.ch06

object Abstraction {

  def productAndCount(): (Int, Int) = {
    val n = readLine()
    if (n != "quit") {
      val (a, c) = productAndCount()
      (a * n.toInt, c + 1)
    } else {
      (1, 0)
    }
  }

  def inputAndCount(base: Int): (Int, Int) = {
    val n = readLine()
    if (n != "quit") {
      val (a, c) = inputAndCount(base)
      (a * n.toInt, c + 1)
    } else {
      (base, 0)
    }
  }

  def inputAndCount(base: Int, func: (Int, Int) => Int): (Int, Int) = {
    val n = readLine()
    if (n != "quit") {
      val (a, c) = inputAndCount(base, func)
      (func(a, n.toInt), c + 1)
    } else {
      (base, 0)
    }

  }

  def add(x: Int, y: Int): Int = x + y

  def main(args: Array[String]): Unit = {
    println("productAndCount")
    val pc = productAndCount()
    println("pc=>" + pc)

    println("inputAndCount")
    val ic = inputAndCount(1)
    println("ic=>" + ic)

    println("inputAndCount -> add")
    val ica = inputAndCount(0, add)
    println("ica=>" + ica)

    println("inputAndCount -> (x,y)=>x*y")
    val icp = inputAndCount(1, (x,y)=>x*y)
    println("icp=>" + icp)
    
    println("inputAndCount -> _*_")
    val icp2 = inputAndCount(1, _*_)
    println("icp2=>" + icp2)

    
    
  }

}