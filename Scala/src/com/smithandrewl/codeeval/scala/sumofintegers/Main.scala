package com.smithandrewl.codeeval.scala.sumofintegers

/*
  CHALLENGE DESCRIPTION:

  Print out the sum of integers read from a file.

  INPUT SAMPLE:

  The first argument to the program will be a path to a filename containing a positive integer, one per line. E.g.

  5
  12
  OUTPUT SAMPLE:

  Print out the sum of all the integers read from the file. E.g.

  17
 */
object Main extends App {
  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)
  val numbers = lines.map(str => str.toInt)
  val sum     = numbers.sum

  println(s"$sum")
}
