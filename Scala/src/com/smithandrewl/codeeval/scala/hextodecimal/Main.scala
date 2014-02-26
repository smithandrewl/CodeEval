package com.smithandrewl.codeeval.scala.hextodecimal

object Main extends App {

  def hexDigitToDec(chr: Char, place: Int): Int = {
    val num = chr match {
      case '0' => 0
      case '1' => 1
      case '2' => 2
      case '3' => 3
      case '4' => 4
      case '5' => 5
      case '6' => 6
      case '7' => 7
      case '8' => 8
      case '9' => 9
      case 'a' => 10
      case 'b' => 11
      case 'c' => 12
      case 'd' => 13
      case 'e' => 14
      case 'f' => 15
    }

    (Math.pow(16, place) * num).toInt
  }

  def hexToDec(num: String): Int = {
    num.reverse.zipWithIndex.map(pair => hexDigitToDec(pair._1, pair._2)).sum
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  lines.map(hexToDec).foreach(println)

}
