package com.smithandrewl.codeeval.trailingstring

object Main extends  App {

  def processLine(line: String) = {
    val parts = line.split(",")
    endsWith(parts(0), parts(1))
  }

  def endsWith(str: String, tail: String): Int = {
    if (str.endsWith(tail)) 1 else 0
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
