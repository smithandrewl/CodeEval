package com.smithandrewl.codeeval.longestword

/*
  CHALLENGE DESCRIPTION:

    In this challenge you need to find the longest word in a sentence. If the sentence has more than one word of the same length you should pick the first one.

  INPUT SAMPLE:

    Your program should accept as its first argument a path to a filename. Input example is the following

    some line with text
    another line
    Each line has one or more words. Each word is separated by space char.

  OUTPUT SAMPLE:

    Print the longest word in the following way.

    some
    another
 */
object Main extends App {
  val source    = scala.io.Source.fromFile(args(0))
  val lines     = source.getLines().filter(_.length > 0)

  def longestWord(words: Vector[String]):String = {
    val sorted  = words.sortWith((lt, rt) => lt.length() > rt.length())
    val longest = sorted(0)

    return longest
  }

  val result = lines.map(line => longestWord(line.split(" ").toVector))

  print(result.mkString("\n"))
}
