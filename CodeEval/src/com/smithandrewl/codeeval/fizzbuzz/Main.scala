package com.smithandrewl.codeeval.fizzbuzz

object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  val result = lines.map(line => {
    val params = line.split(" ").toList.map(_.toInt)

    fizzBuzz(params(0), params(1), params(2)).mkString(" ")
    
  })

  print(result.mkString("\n"))

  def fizzBuzz(firstDiv: Int, secDiv: Int, num: Int) = {
    (1 to num).map(num => {
      List(num % firstDiv == 0, num % secDiv == 0) match {
        case List(false, false) => s"$num"
        case List(true,  false) => "F"
        case List(false, true)  => "B"
        case List(true,  true)  => "FB"
      }
    })
  }
}
