package Cipher
import org.specs2.mutable.Specification

class TestTriangle extends Specification {
  sequential
  "Triangle Program" should {
    "check values" in {
      Triangle.whichTriangle(3,3,3) aka "equilateral" mustEqual "equilateral"
      Triangle.whichTriangle(3,2,3) aka "isosceles" mustEqual "isosceles"
      Triangle.whichTriangle(3,2,1) aka "scalene" mustEqual "scalene"
    }
  }
}
