package com.smithandrewl.codeeval.palindromicranges

import scala.annotation.tailrec

object Main extends App {

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)


  def generateSubRanges(nums: List[Int]): List[List[Int]] = {
    @tailrec
    def subRange(start: Int, range: List[Int], acc: List[List[Int]]): List[List[Int]] = range match {
      case List() => acc
      case head :: tail => {
        val subrange = (start to head).toList
        subRange(start, tail, subrange :: acc)
      }
    }

    @tailrec
    def subRanges(nums: List[Int], acc: List[List[Int]]): List[List[Int]] = nums match {
      case List() => acc
      case head :: tail => subRanges(tail, subRange(head, tail, List[List[Int]]()) ::: acc)
    }

    subRanges(nums, List[List[Int]]())
  }

  def isInteresting(nums: List[Int]): Boolean = {
    countPalindromes(nums) % 2 == 0
  }
  def countPalindromes(nums: List[Int]): Int = {
    nums.count(num => isPalindrome(num))
  }

  def isPalindrome(num: Int): Boolean = {
    val str = num.toString

    str == str.reverse
  }

  def processLine(line: String): String = {
    val numbers = line.split(" ").map(_.toInt)

    val start = numbers(0)
    val end = numbers(1)

    val range = (start to end).toList

    generateSubRanges(range).count(isInteresting).toString

  }

  print(lines.map(processLine).mkString("\n"))
}
