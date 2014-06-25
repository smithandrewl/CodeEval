package com.smithandrewl.codeeval.scala.datarecovery

import scala.annotation.tailrec

object Main extends App {

  def processLine(line: String): String = {
    val parts = line.split(";")
    val oldwords = parts(0).split(" ")
    val indices = parts(1).split(" ").map(_.toInt)


  }


  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  lines.foreach(line => println(processLine(line)))
}
