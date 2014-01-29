package com.smithandrewl.codeeval.fibonacciseries

object Main extends App {
  val source    = scala.io.Source.fromFile(args(0))
  val lines     = source.getLines().filter(_.length > 0)

  val res = lines.map(_.toInt).map(fibonacci(_))

  print(res.mkString("\n"))

  def fibonacci(num: Int): Int = num match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(num - 1 ) + fibonacci(num - 2)
  }


}
