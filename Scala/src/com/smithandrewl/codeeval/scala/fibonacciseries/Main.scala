package com.smithandrewl.codeeval.scala.fibonacciseries

object Main extends App {
  val source    = scala.io.Source.fromFile(args(0))
  val cache = scala.collection.mutable.HashMap[Int, Int]()

  val lines     = source.getLines().filter(_.length > 0)

  val res = lines.map(_.toInt).map(fibonacci)

  res.foreach(println)


  def fibonacci(num: Int): Int = num match {
    case 0 => 0
    case 1 => 1
    case 2 => 1
    case _ => {
      val m = num / 2
      if (num % 2 == 0) {
        val first  = fibonacci(m + 1)
        val second = fibonacci(m - 1)

        (first * first) - (second * second)
      } else {
        val first  = fibonacci(m + 1)
        val second = fibonacci(m)

        (first * first) + (second * second)
      }
    }
  }
}
