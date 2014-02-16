package com.smithandrewl.codeeval.scala.sumofdigits

import scala.annotation.tailrec

object Main extends App {

  def sumOfDigits(num: Int): Int = {
    @tailrec
    def iter(num: Int, acc: Int): Int = num match {
      case 0 => acc
      case _ => iter(num / 10, (num % 10) + acc)
    }

    num match {
      case 0 => 0
      case _ => iter(num, 0)
    }
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  val numbers = lines.map(_.toInt)
  val res = numbers.map(sumOfDigits)

  print(res)
}
