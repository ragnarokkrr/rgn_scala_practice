package org.rgn.scala.steps.ch02

object ex213 {

  def main(args: Array[String]): Unit = {
    var C = new renewCell(5)
    println(C.get())
    C.set(9)
    println(C.get())
    C.restore()
    println(C.get())
  }
}


class cell{
  /*private*/ protected var contents : Int = 0
  def get() = contents
  def set(n: Int) = {
    contents = n
  }
}


class reCell extends cell{
	private var backup : Int = 0
	override def set(n: Int){
	  backup = this.contents
	  super.set(n)
	  //this.contents = n
	}
	def restore() = this.contents - backup
}


class newCell (protected var contents : Int){
	def this() = this(0)
	
	def get() = contents
	def set(n: Int) = {
	  contents = n
	}
}

class renewCell(x : Int) extends newCell(x){
	private var backup : Int = x
	override def set(n: Int) = {
	  backup = this.contents
	  super.set(n)
	}
	def restore() = contents = backup
}