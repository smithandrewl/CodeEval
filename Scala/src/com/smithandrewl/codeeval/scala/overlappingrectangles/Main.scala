package com.smithandrewl.codeeval.scala.overlappingrectangles

object Main extends App {

  case class Point(val x: Int, val y: Int)
  case class Rectangle(val upperLeft: Point, val lowerRight: Point) {
    def overlaps(other: Rectangle): Boolean = {

      val check1 = upperLeft.x  <= other.lowerRight.x
      val check2 = lowerRight.x >= other.upperLeft.x

      val check3 = upperLeft.y  >= other.lowerRight.y
      val check4 = lowerRight.y <=  other.upperLeft.y

      check1 && check2 && check3 && check4
    }
  }

  def processLine(line: String): String = {
    val pieces = line.split(",")
    val numbers = pieces.map(_.toInt)

    val rect1 = Rectangle(Point(numbers(0), numbers(1)), Point(numbers(2), numbers(3)))
    val rect2 = Rectangle(Point(numbers(4), numbers(5)), Point(numbers(6), numbers(7)))

    if (rect1.overlaps(rect2)) "True" else "False"
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
