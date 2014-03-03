package com.smithandrewl.codeeval.scala.armstrongnumbers

import scala.annotation.tailrec

object Main extends App {

  def isArmstrong(num: Int): Boolean = {
    def digits(num: Int): List[Int] = {

      @tailrec
      def iter(num: Int, acc: List[Int]): List[Int] = num match {
        case 0 => acc
        case _ => iter(num / 10, num % 10 :: acc)
      }

      iter(num, List())
    }

    val digs = digits(num)
    val len = digs.length

    digs.map(digit => Math.pow(digit, len)).sum == num
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  val result = lines.map(line => isArmstrong(line.toInt) match {
    case true => "True"
    case _    => "False"
  })

  result.foreach(println)
}
