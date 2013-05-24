package org.rgn.scala.steps.ch02

object ex215 {

  def main(args: Array[String]): Unit = {
    var p = new point(3,2)
    println(p)

    var q = new point3D(4,5,6)
    p=q
    println(p)
    q.translate(1,1,1)
    println(p)
    p.translate(1,1)
    println(p)
    
  }

}


class point(var x: Int, var y: Int){
  def this() = this(0, 0)
  
  def move(x1: Int, y1: Int ) = {x=x1; y=y1}
 
  def translate(dx: Int, dy: Int) = {
    x += dx; y+= dy
  }

  override def toString = "("+x+"+,"+y+")"
}

class point3D(x2d: Int, y2d: Int, var z: Int) 
	extends point(x2d, y2d){
  
  def move(new_x: Int, new_y: Int, new_z: Int) = {
	 x=new_x; y=new_y; z=new_z 
  }
  
  def translate(dx: Int, dy: Int, dz: Int) = {
    x += dx; y+=dy; z += dz;    
  }
    

  override def toString = "("+x+","+","+y+","+z+")"
}