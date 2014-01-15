package com.smithandrewl.codeeval.oddnumbers

/*
  CHALLENGE DESCRIPTION:

    Print the odd numbers from 1 to 99.

  INPUT SAMPLE:

    There is no input for this program.
 */
object Main extends App {
  val result = (1 to 99).filter(num => num % 2 != 0)

  print(result.mkString("\n"))
}
