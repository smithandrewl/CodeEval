package com.smithandrewl.codeeval.scala.compressedsequence

import scala.annotation.tailrec

object Main  extends App {

  def compressSequence(seq: List[Int]): List[(Int, Int)] = {
    @tailrec
    def iter(seq: List[Int], curr: Int, count: Int, acc: List[(Int, Int)]): List[(Int, Int)] = {
      seq match {
        case List()                   => (count, curr) :: acc
        case first :: rest            => first match {
          case first if first == curr => iter(rest, curr, count + 1, acc)
          case _                      => iter(rest, first, 1, (count, curr) :: acc)
        }
      }
    }

    iter(seq, seq.head, 0, List()).reverse
  }

  def processLine(line:String): String = {
    val nums       = line.split(" ").map(_.toInt)
    val compressed = compressSequence(nums.toList)

    compressed.map(pair => pair._1 + " " + pair._2).mkString(" ")
  }


  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  lines.map(processLine).foreach(println)
}
