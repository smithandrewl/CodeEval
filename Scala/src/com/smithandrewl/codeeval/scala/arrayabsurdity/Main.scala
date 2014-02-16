package com.smithandrewl.codeeval.scala.arrayabsurdity

import scala.annotation.tailrec

object Main extends App {

  def arrayAbsurdity(numbers: Array[Int]): Int = {
    @tailrec
    def iter(numbers: Array[Int], acc: Set[Int]): Int = numbers match {
      case Array(head, _*) => acc.contains(head) match {
        case true => head
        case _ => iter(numbers.tail, acc + head)
      }
    }

    iter(numbers, Set())
  }

  def processLine(line: String): String = {
    val numbers = line.split(";")(1).split(",").map(_.toInt)

    arrayAbsurdity(numbers).toString
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))

}
