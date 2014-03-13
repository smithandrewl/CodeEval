package com.smithandrewl.codeeval.scala.nmodm

object Main extends App {

  def mod(n: Int, m: Int): Int = {
    val res: Int = n / m
    n - (m * res)
  }

  def processLine(line: String): String = {
    val Array(n, m) = line.split(",").map(_.toInt)

    mod(n, m).toString
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  lines.map(processLine).foreach(println)
}
