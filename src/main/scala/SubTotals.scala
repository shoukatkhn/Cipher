package Cipher

/*
* Experian Data Lab Test Program
* Given a file with two columns account and amount, find the subtotal of amounts for all unique accounts.
  *  a. Please implement in linear time if possible.
  *  b. When would your linear-time algorithm not work?
* */

object SubTotals {
  var account_info: Map[Int, Int] = Map.empty[Int, Int]
  def total(account: Int, amount: Int): Unit = {
    val updateAmount = account match {
      case acc if account_info.contains(acc) =>
        val amt = account_info(acc) + amount
        amt
      case _ => amount
    }
    account_info ++= Map(account -> updateAmount)
  }

  def main(args: Array[String]): Unit = {
      total(12345, 100)
  }
}
