package com.smithandrewl.codeeval.firstnonrepeatedcharacter

import scala.annotation.tailrec

object Main extends App {

  val source    = scala.io.Source.fromFile(args(0))
  val lines     = source.getLines().filter(_.length > 0)

  def firstNonRepeatedChar(str: String): Char = {
    @tailrec
    def iter(chars: List[Char]): Char = chars match {
      case first :: rest =>
        if(str.count(_ == first) == 1) first
        else iter(rest)
      case Nil => throw new IllegalStateException("List cannot be empty")
    }

    iter(str.toList)
  }

  print(lines.map(firstNonRepeatedChar).mkString("\n"))
}
