package com.smithandrewl.codeeval.scala.decimaltobinary

import scala.annotation.tailrec

object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

   def decimalToBinary(num: Int): String = {
     @tailrec
     def iter(num: Int, acc: List[Int]): List[Int] = {
       if (num == 0) acc
       else iter(num / 2, num % 2 :: acc)
     }

     num match {
       case 0   => "0"
       case _ => iter(num, List()).mkString("")
     }
   }

  val res = lines.map(_.toInt).map(decimalToBinary)

  print(res.mkString("\n"))
}
