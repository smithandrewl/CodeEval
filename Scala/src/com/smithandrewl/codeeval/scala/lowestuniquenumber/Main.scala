package com.smithandrewl.codeeval.scala.lowestuniquenumber

object Main extends App {
  def uniqueNumbers(numbers: Array[Int]): Array[Int] = {
    numbers.filter(number => numbers.count(_ == number) == 1)
  }

  def lowestUnique(numbers: Array[Int]): Int = {
    val unique = uniqueNumbers(numbers)

    unique match {
      case Array() => 0
      case _ => unique.min
    }
  }

  def processLine(line: String): String = {
    val numbers = line.split(" ").map(_.toInt)

    val lowest = lowestUnique(numbers)

    if(lowest != 0) (numbers.indexOf(lowest) + 1).toString
    else "0"
  }

  val source      = scala.io.Source.fromFile(args(0))
  val lines       = source.getLines().filter(_.length > 0)

  lines.map(processLine).foreach(println)
}
