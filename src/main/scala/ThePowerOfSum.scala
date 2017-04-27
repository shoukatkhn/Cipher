/**
  * Find the number of ways that a given integer,X, can be expressed as the sum of the Nth power of unique,
  * natural numbers.
  * If x = 10 and N = 2, we need to find the number of ways that 10 can be represented as the sum of squares
  * of unique numbers. This is the only way in which  can be expressed as the sum of unique squares.
  * 1square + 3square = 10
  * This is the only way in which 10 can be expressed as the sum of unique squares.
  */

object ThePowerOfSum {
  def numberOfWays(x: Int, n: Int, limit: Int, i: Int) : Int = {
    x match {
      case a if x == 0 => 1
      case b if i > limit || x < 0 => 0
      case _ =>
        numberOfWays(x - math.pow(i, n).toInt, n, limit, i + 1) + numberOfWays(x, n, limit, i + 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val x = 10 ; val n = 2
    val recursionLimit = math.pow(x, 1 / n.toFloat).toInt
    numberOfWays(x,n,recursionLimit,1)
  }
}
