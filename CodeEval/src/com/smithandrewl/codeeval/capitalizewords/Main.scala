package com.smithandrewl.codeeval.capitalizewords

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)
  val res    = lines.map(doLine(_))

  def doLine(line: String): String = {
    val words           = line.split(" ").toList
    val titleCasedWords = words.map(word => toTitleCase(word))

    titleCasedWords.mkString(" ")
  }

  def toTitleCase(str: String): String = str match {
    case "" => ""
    case _ => {
      val split = str.toList;
      (split.head.toUpper :: split.tail).mkString("")
    }
  }

  print(res.mkString("\n"))
}
