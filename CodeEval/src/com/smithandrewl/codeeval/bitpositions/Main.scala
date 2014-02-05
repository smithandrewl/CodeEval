package com.smithandrewl.codeeval.bitpositions

import scala.annotation.tailrec

object Main extends App {

  def toBinary(num: Int): List[Int] = {
    @tailrec
    def iter(num: Int, acc: List[Int]): List[Int] = num match {
      case 0 => acc
      case num => iter(num / 2, (num %2) :: acc)
    }

    if(num == 0) List(0)
    else iter(num, List())
  }

  def bitsEqual(num: Int, pos1: Int, pos2: Int): Boolean = {
    val bits = toBinary(num)
    val len  = bits.length

    bits(len - pos1) == bits(len - pos2)
  }

  def processLine(line: String): String = {
    val pieces = line.split(",")
    val nums   = pieces.map(_.toInt)

    val num  = nums(0)
    val pos1 = nums(1)
    val pos2 = nums(2)

    bitsEqual(num, pos1, pos2).toString
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
