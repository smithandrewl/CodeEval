package com.smithandrewl.codeeval.stackimplementation

import scala.annotation.tailrec

object Main extends App {

  def push(num: Int, stack: List[Int]): List[Int] = {
    num :: stack
  }

  def pop(stack: List[Int]): Int = {
    stack.head
  }

  def processLine(line: String): String = {
    val numbers = line.split(" ").map(_.toInt)

    @tailrec
    def addToStack(numbers: List[Int], acc: List[Int]): List[Int] = {
      numbers match {
        case List() => acc
        case head :: tail => addToStack(tail, push(head, acc))
      }
    }

    @tailrec
    def everyOther(stack: List[Int], even: Boolean, acc: List[Int]): List[Int] = {
      stack match {
        case List() => acc.reverse
        case head :: tail => if(even) {
          everyOther(tail, false, head :: acc)
        } else {
          everyOther(tail, true, acc)
        }
      }
    }

    val stack = addToStack(numbers.toList, List())
    everyOther(stack, true, List()).mkString(" ")
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
