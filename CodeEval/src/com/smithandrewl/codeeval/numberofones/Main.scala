package com.smithandrewl.codeeval.numberofones

import scala.annotation.tailrec

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def numberOfOnes(num: Int): Int = {
    @tailrec
    def iter(num: Int, acc: Int): Int = num match {
      case 0 => acc
      case num => {
        val res = num / 2
        (num % 2) match {
          case 1 => iter(res, acc + 1)
          case _ => iter(res, acc)
        }
      }
    }

    iter(num, 0)
  }

  def processLine(line:String): String = {
    numberOfOnes(line.toInt).toString
  }

  print(lines.map(processLine).mkString("\n"))
}
