package com.smithandrewl.codeeval.scala.minimumcoins

object Main extends App {

  def minimumCoins(amount: Int): Int = {
    val numFives  = amount / 5
    val numThrees = (amount % 5) / 3
    val numOnes   = (amount % 5) % 3

    numFives + numThrees + numOnes

  }

  val source      = scala.io.Source.fromFile(args(0))
  val lines       = source.getLines().filter(_.length > 0)

  lines.map(line => minimumCoins(line.toInt)).foreach(println)
}
