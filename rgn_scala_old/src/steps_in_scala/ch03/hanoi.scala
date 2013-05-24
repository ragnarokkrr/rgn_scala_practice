package ch03

object hanoi {
  def main(args: Array[String]) {
	  println(hanoi(2))
  }
  
  def hanoi(n: Int): List[String] = {
    def move(A:String, B:String) = List(A+B)
    
    def _hanoi(n: Int
        , A: String
        , B: String
        , C: String): List[String] =
      if(n>1)
        _hanoi(n-1, A, C, B):::move(A,B):::_hanoi(n-1,C,B,A)
      else
        List()
    
        
    _hanoi(n, "A", "B", "C")
  }
}