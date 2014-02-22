package com.smithandrewl.codeeval.scala.multiplesofanumber

import scala.annotation.tailrec

object Main extends App {
  def firstMult(n: Int, x: Int): Int = {
    @tailrec
    def iter(acc: Int): Int = {
      if(acc > n) acc
      else iter(acc + x)
    }

    if(n == x) n
    else iter(x)
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)


  def processLine(line: String): String = {
    val Array(first, second) = line.split(",")

    val n = first.toInt
    val x = second.toInt

    firstMult(n, x).toString
  }

  lines.map(processLine).foreach(println)
}
