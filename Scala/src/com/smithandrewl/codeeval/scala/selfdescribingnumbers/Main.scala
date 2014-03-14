package com.smithandrewl.codeeval.scala.selfdescribingnumbers

import scala.annotation.tailrec

object Main extends App {

  def digits(num: Int): Vector[Byte] = {
    @tailrec
    def iter(num: Int, acc: Vector[Byte]): Vector[Byte] = num match {
      case 0 => acc
      case _ => iter(num / 10, (num % 10).toByte +: acc)
    }

    iter(num, Vector())
  }

  def isSelfDescribing(num: Int): Boolean = {
    val digs = digits(num)

    @tailrec
    def iter(idx: Int): Boolean = {
      if(idx >= digs.length) true
      else if (digs.count(digit => digit == idx) == digs(idx))
        iter(idx + 1)
      else
        false
    }

    iter(0)
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  val nums = lines.map(_.toInt)

  val res = nums.foreach(num => isSelfDescribing(num) match {
    case true => println("1")
    case _    => println("0")
  })

}
