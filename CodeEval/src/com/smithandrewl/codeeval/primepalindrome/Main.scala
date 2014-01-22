package com.smithandrewl.codeeval.primepalindrome

/*
  CHALLENGE DESCRIPTION:
    Write a program to determine the biggest prime palindrome under 1000.
  INPUT SAMPLE:
    There is no input for this program.
  OUTPUT SAMPLE:
    Your program should print the largest palindrome on stdout, i.e.
    929
*/
object Main extends App {
  val primes = for {
    num <- 3 until 1000 by 2
    numStr = num.toString

    if numStr == numStr.reverse
    if isPrime(num)
  } yield num

  print(primes.last)

  def isPrime(num: Int): Boolean = {
    val start = 2
    val end   = Math.sqrt(num).toInt

    !(start until end).exists(num % _ == 0)
  }
}
