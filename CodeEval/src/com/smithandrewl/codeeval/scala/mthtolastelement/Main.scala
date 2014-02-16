package com.smithandrewl.codeeval.scala.mthtolastelement

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    val numbers = line.split(" ")
    val m       = numbers.last.toInt
    val lst     = numbers.slice(0, numbers.length - 1)

    mthToLast(lst, m)
  }

  def mthToLast(numbers: Array[String], m: Int): String = {
    if(m > numbers.length) ""
    else numbers(numbers.length - m)
  }

  print(lines.map(processLine).mkString("\n"))
}
