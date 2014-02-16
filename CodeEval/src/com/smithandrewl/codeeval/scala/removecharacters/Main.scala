package com.smithandrewl.codeeval.scala.removecharacters

object Main extends App {
  def removeCharacters(str: String, chrs: String): String = {
    val split = chrs.toCharArray;

    str.filter(chr => !split.contains(chr))
  }

  def processLine(line: String): String = {
    val parts = line.split(", ")

    removeCharacters(parts(0), parts(1))
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
