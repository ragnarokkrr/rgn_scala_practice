package org.rgn.scala.steps.ch03

abstract class SExp
case object NilSExp extends SExp
case class Atom(elem: Char) extends SExp
case class Pair(left: SExp, right: SExp) extends SExp

object SExp {

  def main(args: Array[String]): Unit = {
    //var sexp = createSExp

    var sexp = Pair(Atom('a'), Pair(Atom('b'), Atom('c')))
    println(sexp)
    printSExp(sexp)
    println()
    car(sexp)
  }

  def car(sexp: SExp): Unit = {
	var found = false
    def _car(sexp: SExp): Unit = {
      (sexp, found) match {
        case (Atom(elem), false) => {println(elem); found = true}
        case (_, true) => ()
        case (Pair(l, r), _) => {_car(l); _car(r) }
      }
    }
    _car(sexp)
  }

  def printSExp(sexp: SExp): Unit = {

    sexp match {
      case Atom(elem) => print(elem)
      case Pair(left, right) => {
        print("(")
        printSExp(left)
        print(",")
        printSExp(right)
        print(")")
      }

    }

  }

  def createSExp(): SExp = {
    val NIL = 0; val ATOM = 1
    println("Enter choice...")
    println("\t0 for NIL")
    print("\t1 for PAIR\n?")
    val choice: Int = readInt()
    if (choice == NIL)
      NilSExp
    else if (choice == ATOM) {
      print("Enter Atom....\n?")
      val s: Char = readChar()
      Atom(s)
    } else
      Pair(createSExp, createSExp)
  }

}