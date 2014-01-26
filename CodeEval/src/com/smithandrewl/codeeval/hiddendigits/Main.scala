package com.smithandrewl.codeeval.hiddendigits

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  val table  = Map( 'a' ->  0,  'b' ->  1,  'c' ->  2,  'd' ->  3,  'e' ->  4,
                    'f' ->  5,  'g' ->  6,  'h' ->  7,  'i' ->  8,  'j' ->  9,
                    '0' -> '0', '1' -> '1', '2' -> '2', '3' -> '3', '4' -> '4',
                    '5' -> '5', '6' -> '6', '7' -> '7', '8' -> '8', '9' -> '9')

  val valid = table.keySet

  val out = for {
    line <- lines
    filtered = line.filter(chr => valid.contains(chr))
    result   = filtered.map(table(_))
  } yield if (result.isEmpty) "NONE" else result.mkString("")

  print(out.mkString("\n"))

}
