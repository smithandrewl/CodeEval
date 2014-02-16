package com.smithandrewl.codeeval.scala.multiplylists

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    val sides     = line.split('|')
    val leftInts  = sides(0).trim().split(" ").map(_.toInt)
    val rightInts = sides(1).trim().split(" ").map(_.toInt)

    multiplyInts(leftInts, rightInts).mkString(" ")
  }

  def multiplyInts(first: Array[Int], second: Array[Int]) = {
    (first zip second).map(pair => pair._1 * pair._2)
  }

  print(lines.map(processLine).mkString("\n"))
}
