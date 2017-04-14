package Cipher
/**
    * Anna and Brian order n items at a restaurant, but Anna declines to eat any of the kth item (where 0 <= k <= n)
    * due to an allergy. When the check comes, they decide to split the cost of all the items they shared;
    * however, Brian may have forgotten that they didn't split the  item and accidentally charged Anna for it.
    * You are given n,k, the cost of each of the  items, and the total amount of money that Brian charged Anna
    * for her portion of the bill. If the bill is fairly split, print Bon Appetit; otherwise,
    * print the amount of money that Brian must refund to Anna.
  */

import scala.io.StdIn
object BonApetit {
  def splitwise(n: Int, costOfK: Int, total: Int, charged: Int): Unit = {
    val a_share = (total - costOfK) / 2
    charged match {
      case `a_share` => println("Bon Appetit")
      case _ => println(s"${charged - a_share}")
    }
  }

  def main(args: Array[String]): Unit = {
    val Array(n, k) = StdIn.readLine().split(" ").map(_.toInt)
    val items = StdIn.readLine().split(" ").map(_.toInt)
    val charged = StdIn.readLine().toInt

    splitwise(n,items(k),items.sum, charged)
  }
}
