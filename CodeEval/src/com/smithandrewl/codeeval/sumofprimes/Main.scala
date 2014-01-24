package com.smithandrewl.codeeval.sumofprimes

import scala.annotation.tailrec

object Main extends App {
  def primes(start: Long): Stream[Long] = {
    def isPrime(num: Long): Boolean = {
      @tailrec
      def iter(cur: Long): Boolean = {
        if (cur > Math.sqrt(num).toInt) true
        else if(num % cur == 0) false
        else iter(cur + 1)
      }

      iter(2)
    }

    start match {
      case num if isPrime(num) => num #:: primes(num + 1)
      case num                 => primes(num + 1)
    }
  }

  print(primes(2).take(1000).toList.sum)
}
