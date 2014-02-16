package com.smithandrewl.codeeval.scala.lowercase

object Main extends App {
  val source      = scala.io.Source.fromFile(args(0))
  val lines       = source.getLines().filter(_.length > 0)
  val transformed = lines.map(_.toLowerCase)

  print(transformed.mkString("\n"))
}