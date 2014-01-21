package com.smithandrewl.codeeval.uniqueelements

object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  val output = lines.map(line => {
    val uniq = line.split(",").map(_.toInt).toSet.toList.sorted

    uniq.mkString(",")
  })

  print(output.mkString("\n"))
}
