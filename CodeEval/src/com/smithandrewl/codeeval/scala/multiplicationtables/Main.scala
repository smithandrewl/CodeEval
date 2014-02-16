package com.smithandrewl.codeeval.scala.multiplicationtables

object Main extends App {
  val table = for {
    i <- 1 to 12

    row = for {j <- 1 to 12} yield "%3s".format(i * j)
  } yield row.mkString(" ")

  print(table.mkString("\n"))
}
