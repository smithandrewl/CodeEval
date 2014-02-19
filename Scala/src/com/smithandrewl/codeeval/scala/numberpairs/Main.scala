package com.smithandrewl.codeeval.scala.numberpairs

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def pairsWhichSumToN(list: List[Int], n: Int): Set[(Int, Int)] = {
    val pairs = for {
      i <- 0 until list.length
      j <- i until list.length

      if list(i) + list(j) == n
    } yield (list(i), list(j))

    pairs.toSet
  }

  def processLine(line: String): String = {
    val Array(left, right) = line.split(";");

    val numbers = left.split(",").map(_.toInt)
    val n = right.toInt

    val pairs = pairsWhichSumToN(numbers.toList, n)

    if(pairs.isEmpty) "NULL"
    else {
      (for {
        pair <- pairs.toList
      } yield pair._1.toString + "," + pair._2.toString).mkString(";")
    }
  }

  lines.map(processLine).foreach(println)
}
