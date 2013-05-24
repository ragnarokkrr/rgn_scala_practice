package org.rgn.scala.steps.ch02

object ex216 {

  def main(args: Array[String]): Unit = {
    var max = (x: Int, y: Int, z: Int) =>{
      var maior = x
      if (y > maior) maior = y
      if (z > maior) maior = z
    }
    
    println(max(3,6,7))
    
  }

}


