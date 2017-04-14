package Cipher

/*
* Given two lists, write a function that answers if all elements of one list are in the other
* */

object CompareList {
    def compare(first: List[Int], second: List[Int]): Boolean = {
     first.sorted.zip(second.sorted).forall{
       case(x,y) => x == y
     }
  }

  def main(args: Array[String]): Unit = {
    val first = List(1,2,3)
    val second = List(2,1,3)
    compare(first,second)
  }
}
