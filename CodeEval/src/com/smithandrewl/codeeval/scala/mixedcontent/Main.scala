package com.smithandrewl.codeeval.scala.mixedcontent

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    val pieces = line.split(",")

    val (strs, nums) = pieces partition { case x if (!isNumeric(x)) => true; case _ => false }

    val strsLst = strs.toList
    val numsLst = nums.toList

    (strsLst, numsLst) match {
      case (List(), num) => numsLst.mkString(",")
      case (num, List()) => strsLst.mkString(",")
      case (strs, nums)  => strsLst.mkString(",") + "|" + numsLst.mkString(",")
    }
  }

  def isNumeric(str: String): Boolean = {
    try {
      str.toInt
      true
    } catch {
      case _ => false
    }
  }

  print(lines.map(processLine).mkString("\n"))
}

