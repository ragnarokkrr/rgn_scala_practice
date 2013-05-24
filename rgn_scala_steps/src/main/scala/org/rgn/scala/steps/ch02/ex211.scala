package org.rgn.scala.steps.ch02


object ex211 {

  def main(args: Array[String]) { 
		var max	= 0
		var EOF	= false
		var firstTime = true
		var x = 0
		
		do {
			print ("gimme a number: ");
			
			try{
				x = readInt()
				println(x)
			}catch{
				case eof: java.io.IOException => EOF = !EOF
				case numFormat: java.lang.NumberFormatException => EOF = !EOF
			}
		
			
			if (!EOF){
				if(firstTime){
					max = x
					firstTime = !firstTime
				}
				if (x > max)
					max = x
			}
		} while(!EOF)
		println("maximum is " + max)
  }
}