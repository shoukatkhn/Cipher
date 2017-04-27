def numberOfWays(x: Int, n: Int, limit: Int, i: Int) : Int = {
  x match {
    case a if x == 0 => 1
    case b if i > limit || x < 0 => 0
    case _ =>
      numberOfWays(x - math.pow(i, n).toInt, n, limit, i + 1) + numberOfWays(x, n, limit, i + 1)
  }
}

val x = 10 ;val n = 2
val limit = math.pow(x, 1/n.toFloat).toInt
numberOfWays(x,n,limit,1)


