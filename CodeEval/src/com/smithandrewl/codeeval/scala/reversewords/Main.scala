package com.smithandrewl.codeeval.scala.reversewords

/*
  CHALLENGE DESCRIPTION:

  Write a program to reverse the words of an input sentence.

  INPUT SAMPLE:

    The first argument will be a path to a filename containing multiple sentences, one per line.
    Possibly empty lines too. E.g.

    Hello World
    Hello CodeEval

  OUTPUT SAMPLE:

    Print to stdout, each line with its words reversed, one per line. Empty lines in the input
    should be ignored. Ensure that there are no trailing empty spaces on each line you print. E.g.

    World Hello
    CodeEval Hello
 */
object Main extends App {
  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  val result  = for {
    reversedLine <- lines.map(line => line.split(" ").reverse)
  } yield reversedLine.mkString(" ")

  result.foreach(println)
}
