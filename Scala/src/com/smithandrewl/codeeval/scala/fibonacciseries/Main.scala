package com.smithandrewl.codeeval.scala.fibonacciseries

object Main extends App {
  val source    = scala.io.Source.fromFile(args(0))
  val cache = scala.collection.mutable.HashMap[Int, Int]()

  val lines     = source.getLines().filter(_.length > 0)

  val res = lines.map(_.toInt).map(fibonacci)

  print(res.mkString("\n"))

  def fibonacci(num: Int): Int = num match {
    case 0 => 0
    case 1 => 1
    case _ => {
      if(cache.contains(num)) cache(num)
      else {
        val result = fibonacci(num - 1 ) + fibonacci(num - 2)

        cache(num) = result

        result
      }
    }
  }
}
