package com.smithandrewl.codeeval.scala.findawriter

import java.util.regex.Pattern

object Main extends App {

  def decode(msg: String, key: String): String = {
    val messageEx = msg.toVector
    val keyEx = key.trim.split(" ").map(_.toInt)

    keyEx.map(keyNum => messageEx(keyNum - 1)).mkString("")
  }

  val source    = scala.io.Source.fromFile(args(0))
  val lines     = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    val Array(message, key) = line.split(Pattern.quote("|"))

    decode(message, key)
  }

  lines.map(processLine).foreach(println)
}
