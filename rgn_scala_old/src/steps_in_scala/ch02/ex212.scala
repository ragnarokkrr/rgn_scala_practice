package ch02


object ex212 {

  def main(args: Array[String]): Unit = {
    var l = new Lemon()
    println ("price: "+ l.price() + " color: " + l.color)

    def worth(f: Fruit) = f.price()
    var l2 = new Lemon()
    var f = new Fruit()
    f = l2
    println(worth(f))
    
  }

}



class Fruit{
	def price() = 0.5
}

class Lemon extends Fruit{
	override def price() = 0.2
	def color() = "yellow"

}

