package com.smithandrewl.codeeval.scala.beautifulstrings

import scala.annotation.tailrec

object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def maximumBeauty(str: String): Int = {

    @tailrec
    def iter(info: List[Int], idx: Int, sum: Int): Int = info match {
      case List() => sum
      case x :: xs => iter(xs, idx - 1, sum + (x * idx))
    }

    val normalized = str.toLowerCase
    val unique = normalized.toSet.filter("abcdefghijklmnopqrstuvwxyz".contains(_))

    val info: List[Pair[Char, Int]] = unique.map(chr  => Pair(chr, normalized.count(chr2 => chr2 == chr))).toList
    val sorted = info.sortWith((left, right) => left._2 > right._2)

    iter(sorted.map(_._2), 26, 0)
  }

  lines.map(maximumBeauty).foreach(println)
}
