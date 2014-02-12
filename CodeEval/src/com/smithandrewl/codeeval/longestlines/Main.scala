package com.smithandrewl.codeeval.longestlines

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)
  val num    = lines.next().toInt

  def longestLines(lines: Vector[String], numLines: Int): Vector[String] = {
    lines.sortBy(-_.length).take(numLines)
  }

  print(longestLines(lines.toVector, num).mkString("\n"))
}
