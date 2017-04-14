package Cipher

import org.specs2.mutable.Specification

class TestCompareList extends Specification {
  sequential

  "compare list" should {
    "compare list" in {
      CompareList.compare(List(1,2,3),List(3,2,1)) aka "same elements" must beTrue
      CompareList.compare(List(3,1,1),List(3,3,3)) aka "different list" must beFalse
    }
  }
}
