package Cipher

/*
* Write a function that takes three sides of a triangle and answers if it's equilateral, isosceles, or scalene.
* */

object Triangle {
  def whichTriangle(a: Int, b: Int, c: Int): String = {
    /*
    creating a new set will return unique elements
    if there is only one unique element in Set means all sides are equal
    and triangle is equilateral else isosceles or scalene
    */

    val set = Set(a,b,c)
    set.size match {
      case 1 => "equilateral"
      case 2 => "isosceles"
      case 3 => "scalene"
      case _ => ""
    }
  }

  def main(args: Array[String]): Unit = {
    whichTriangle(3,3,3)
  }
}
