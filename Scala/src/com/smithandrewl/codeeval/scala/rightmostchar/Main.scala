package com.smithandrewl.codeeval.scala.rightmostchar

object Main extends App {
  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  def processLine(line: String): Int = {
    val pieces = line.split(",")
    val word = pieces(0)
    val chr = pieces(1)(0)

    word.lastIndexOf(chr)
  }

  print(lines.map(processLine).mkString("\n"))

}
