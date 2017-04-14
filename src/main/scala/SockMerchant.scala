/**
    * John's clothing store has a pile of n loose socks where each sock i is labeled with an integer,ci,
    * denoting its color. He wants to sell as many socks as possible, but his customers will only buy them in
    * matching pairs. Two socks,i and j, are a single matching pair if ci == cj.
  */

import scala.io.StdIn
object SockMerchant {
  def findPairs(items: Array[Int]): Unit = {
    var count = 0
    items.distinct.foreach {
      i =>
        count += items.count(_ == i) / 2
    }
    println(count)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val items = StdIn.readLine()
      .split(" ")
      .map(_.toInt)

    findPairs(items)
  }
}
