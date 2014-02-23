package com.smithandrewl.codeeval.scala.reverseandadd

import scala.annotation.tailrec

object Main extends App {

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  def reverseAndAdd(num: Long): (Long, Long) = {

    def reverseNum(num: Long): Long = {
      num.toString.reverse.toInt
    }

    def isPalindrome(num: Long): Boolean = {
      reverseNum(num) == num
    }

    @tailrec
    def iter(num: Long, count: Long): (Long, Long) = num match {
      case num if isPalindrome(num) => (count, num)
      case num                      => iter(num + reverseNum(num), count + 1)
    }

    iter(num, 0)
  }

  val nums = lines.map(_.toLong)

  nums.map(reverseAndAdd).map(pair => pair._1 + " " + pair._2).foreach(println)
}
