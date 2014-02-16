package com.smithandrewl.codeeval.scala.countingprimes

object Main extends App {

  def sieveOfEratosthenes(curr: Int, primes: List[Int]): Stream[Int] = {
    def isPrime(num: Int): Boolean = {
      val numbers = (2 to Math.sqrt(num).toInt)

      !numbers.exists(curr => num % curr == 0)
    }

    val possiblePrime = !primes.exists(prime => curr % prime == 0)

    if(possiblePrime && isPrime(curr))
      curr #:: sieveOfEratosthenes(curr + 1, curr :: primes)
    else
      sieveOfEratosthenes(curr + 1, primes)
  }

  def processLine(line: String): String = {
    val numbers = line.split(",").map(_.toInt)

    val primes = sieveOfEratosthenes(numbers(0), List()).takeWhile(num => num <= numbers(1))

    primes.length.toString
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines  = source.getLines().filter(_.length > 0)

  print(lines.map(processLine).mkString("\n"))
}
