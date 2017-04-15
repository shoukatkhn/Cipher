package Cipher

import org.specs2.mutable.Specification

class TestFindFifthElement extends Specification {
  sequential
  val input = Node(Array(1,2,3,4,5,6,7,8,9,10))

  "FindFifthElement" should {
    "verify value" in {
      val result = FindFifthElement.getFifthElement(input).data
      result aka "fifth element from tail" mustEqual 6
    }
  }
}
