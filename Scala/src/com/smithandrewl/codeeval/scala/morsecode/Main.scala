package com.smithandrewl.codeeval.scala.morsecode

object Main extends App {

  val codeTable = Map(
    ".-"    -> "A",
    "-..."  -> "B",
    "-.-."  -> "C",
    "-.."   -> "D",
    "."     -> "E",
    "..-."  -> "F",
    "--."   -> "G",
    "...."  -> "H",
    ".."    -> "I",
    ".---"  -> "J",
    "-.-"   -> "K",
    ".-.."  -> "L",
    "--"    -> "M",
    "-."    -> "N",
    "---"   -> "O",
    ".--."  -> "P",
    "--.-"  -> "Q",
    ".-."   -> "R",
    "..."   -> "S",
    "-"     -> "T",
    "..-"   -> "U",
    "...-"  -> "V",
    ".--"   -> "W",
    "-..-"  -> "X",
    "-.--"  -> "Y",
    "--.."  -> "Z",
    ".----" -> "1",
    "..---" -> "2",
    "...--" -> "3",
    "....-" -> "4",
    "....." -> "5",
    "-...." -> "6",
    "--..." -> "7",
    "---.." -> "8",
    "----." -> "9",
    "-----" -> "0"
  )

  def decode(word: Array[String]): String = {
    val letters = for {
      letter <- word
    } yield codeTable(letter)

    letters.mkString
  }

  def processLine(line: String): String = {
    val words = for {
      chr <- line.split("  ")
    } yield decode(chr.split(" "))

    words.mkString(" ")
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  lines.foreach(line => println(processLine(line)))
}
