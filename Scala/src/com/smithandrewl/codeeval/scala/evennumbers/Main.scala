package com.smithandrewl.codeeval.scala.evennumbers

/*
  CHALLENGE DESCRIPTION:

    Write a program which checks input numbers and determines whether a number is even or not.

  INPUT SAMPLE:

    Your program should accept as its first argument a path to a filename. Input example is the following

    701
    4123
    2936
  OUTPUT SAMPLE:

    Print 1 if the number is even or 0 if the number is odd.

    0
    0
    1

  All numbers in input are integers > 0 and < 5000.
 */
object Main extends App {
  val source    = scala.io.Source.fromFile(args(0))
  val lines     = source.getLines().filter(_.length > 0)
  val numbers   = lines.map(line => line.toInt)
  val evenOrOdd = numbers.map(num => if(num % 2 == 0) 1 else 0)

  val result = evenOrOdd.mkString("\n")

  print(s"$result")
}
