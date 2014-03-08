package com.smithandrewl.codeeval.scala.happynumber

import scala.annotation.tailrec

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def sumOfSquareOfDigits(number: Int): Int = {
    @tailrec
    def iter(number: Int, acc: Int): Int = number match {
      case 0 => acc
      case _ => {
        val digit  = number % 10
        val result = number / 10

        iter(result, (digit * digit) + acc)
      }
    }
    iter(number, 0)
  }

  def isHappyNumber(number: Int): Boolean = {
    @tailrec
    def iter(number: Int, iterations: Int): Boolean = (number, iterations) match {
      case (_, it) if it > 10 => false
      case (1, _) => true
      case (_, _) => iter(sumOfSquareOfDigits(number), iterations + 1)
    }

    iter(number, 0)
  }

  val numbers = lines.map(_.toInt)

  val results = for {
    number <- numbers
    result = {
      if (isHappyNumber(number)) "1"
      else "0"
    }
  } yield result

  results.foreach(println)
}
