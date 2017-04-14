package Cipher
/*
* tail recursion solution for factorial.
* the program will not throw any stack overflow errors for BigInts
* */

object TailRecursionExample {
  def factorial(n: BigInt, result: BigInt): BigInt = {
    if(n == 1) result else factorial(n - 1, n*result)
  }

  def fact(n: BigInt): BigInt = factorial(n,1)

  def main(args: Array[String]): Unit = {
    fact(10000)
  }
}
