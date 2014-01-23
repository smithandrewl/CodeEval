package com.smithandrewl.codeeval.sumofprimes

import scala.util.Random

object Main extends App {
  val rnd = new Random()
  def primes(start: Long): Stream[Long] = start match {
    case num if isPrime(num) => num #:: primes(num + 1)
    case num                 => primes(num + 1)
  }

  def isPrime(num: Long): Boolean = {
    !(2 until Math.sqrt(num).toInt).exists(num % _ == 0)
  }

  print(primes(2).take(1000).toList.sum)

}
