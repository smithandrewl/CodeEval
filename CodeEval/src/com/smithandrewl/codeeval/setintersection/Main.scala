package com.smithandrewl.codeeval.setintersection

object Main extends App {

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    val parts = line.split(";")

    val set1 = parts(0).split(",").map(_.toInt)
    val set2 = parts(1).split(",").map(_.toInt)

    val intersection = set1.intersect(set2)

    if(intersection.length == 0)
      ""
    else
      intersection.mkString(",")

  }

  print(lines.map(processLine).mkString("\n"))
}
