package com.smithandrewl.codeeval.sumofdigits

import scala.annotation.tailrec

object Main extends App {

  def digits(num: Int): List[Byte] = {
    @tailrec
    def iter(num: Int, acc: List[Byte]): List[Byte] = num match {
      case 0 => acc
      case _ => iter(num / 10, (num % 10).toByte :: acc)
    }

    num match {
      case 0 => List[Byte](0x0)
      case _ => iter(num, List())
    }
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  val numbers = lines.map(_.toInt)
  val res = numbers.map(digits(_).sum)

  print(res.mkString("\n"))
}
