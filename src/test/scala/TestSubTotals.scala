package Cipher

import org.specs2.mutable.Specification
import scala.io.Source

/**
  * Created by shoukathkhan on 4/14/17.
  */
class TestSubTotals extends Specification {
  "unique totals" should {
    "add_amounts_for_accounts" in {
      Source.fromFile("src/test/resources/account-information").getLines().foreach {
        line =>
          val Array(acc, amt) = line.split(",").map(_.toInt)
          SubTotals.total(acc, amt)
      }
      SubTotals.account_info(12345) aka "unique account value" mustEqual 900
    }
  }
}
