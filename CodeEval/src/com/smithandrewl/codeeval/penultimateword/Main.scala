package com.smithandrewl.codeeval.penultimateword

import scala.annotation.tailrec

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def penultimate(items: List[String]) = {
    @tailrec
    def iter(items: List[String]): String = items match {
      case first :: second :: Nil => first
      case head  :: tail          => iter(tail)
    }

    iter(items)
  }

  print(lines.map(line => penultimate(line.split(" ").toList)).mkString("\n"))
}
