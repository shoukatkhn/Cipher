package Cipher
import org.specs2.mutable.Specification

/**
  * Created by shoukathkhan on 4/17/17.
  */
class TestInsertionSort extends Specification {
  "Insertion Sort Part 1" should {
    "verify results" in {

    }
  }

  "Insertion Sort Part 2" should {
    "verify results" in {
      val expectedResult = Array(1,2,3,4,5,6)
      val input = Array(1,4,3,5,6,2)
      val result = InsertionSortPart2.iSort(input)
      expectedResult aka "Sorted array" mustEqual result
    }
  }
}
