object FirstExample {

  def main(args: Array[String]): Unit = {
    var z: Array[Int] = new Array[Int](10);
  	for (i <- List.range(0, z.length, 1)){
  		z(i) = new java.util.Random().nextInt(100)
  	}
  	println ("AA\n" + z )
  	
  	println ("Fabio*2, Rafael")
  	
  	
  }

  def sort(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i); xs(i) = xs(j); xs(j) = t
    }

    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)

      var i = l; var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1

        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }

      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)

    }

    sort1(0, xs.length - 1)
  }

}