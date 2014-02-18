package com.smithandrewl.codeeval.scala.pointincircle

import java.util.regex.Pattern

/*
  POINT IN CIRCLE
  CHALLENGE DESCRIPTION:

  Having coordinates of the center of a circle, it's radius and coordinates of a point you need to define whether this
  point is located inside of this circle.

  INPUT SAMPLE:

    Your program should accept as its first argument a path to a filename. Input example is the following

    Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)
    Center: (5.05, -11); Radius: 21.2; Point: (-31, -45)
    Center: (-9.86, 1.95); Radius: 47.28; Point: (6.03, -6.42)
    All numbers in input are between -100 and 100

  OUTPUT SAMPLE:

    Print results in the following way.

    true
    false
    true
 */
object Main extends App {
  case class Point(x: Float, y: Float)
  case class Circle(radius: Float, point: Point)

  def pointInCircle(circle: Circle, point: Point): Boolean = {
    def distance(point1: Point, point2: Point): Float = {
      val xDiff = point2.x - point1.x
      val yDiff = point2.y - point1.y

      Math.abs(Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))).toFloat
    }

    distance(point, circle.point) < circle.radius
  }


  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  def processLine(line: String): String = {
    def parsePoint(line: String): Point = {
      val Array(circXStr, circYStr) = line.split(Pattern.quote("("))(1).split(", ")

      val circX = circXStr.toFloat
      val circY = circYStr.substring(0, circYStr.indexOf(')')).toFloat

      Point(circX, circY)
    }

    val Array(center, radiusStr, pointStr) = line.split(";")

    val circleCenter = parsePoint(center)
    val radius       = radiusStr.split(":")(1).toFloat
    val point        = parsePoint(pointStr)

    pointInCircle(Circle(radius, circleCenter), point).toString
  }

  lines.map(processLine).foreach(println)
}
