package com.smithandrewl.codeeval.wordtodigit

object Main extends App {

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  val map = Map("zero" -> 0, "one" -> 1, "two"   -> 2, "three" -> 3, "four" -> 4,
                "five" -> 5, "six" -> 6, "seven" -> 7, "eight" -> 8, "nine" -> 9)

  def processLine(line: String): String   = {
    val digits = for {
      word <- line.split(";")
      digit = map(word)
    } yield digit

    digits.mkString("")
  }

  print(lines.map(processLine).mkString("\n"))

}
