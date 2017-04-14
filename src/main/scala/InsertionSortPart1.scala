/**
  * Given a sorted list with an unsorted number e in the rightmost cell,
  * can you write some simple code to insert e into the array so that it
  * remains sorted? Print the array every time a value is shifted in the
  * array until the array is fully sorted. The goal of this challenge is
  * to follow the correct order of insertion sort.
  *
  * sample input: 5
                : 2 4 6 8 3
  * sample output:
  * 2 4 6 8 8
  * 2 4 6 6 8
  * 2 4 4 6 8
  * 2 3 4 6 8 
  */

import scala.io.StdIn
object InsertionSortPart1 {
  def insertionSort(size: Int, input: Array[Int]): Unit = {
    val temp = input(size - 1)
    var i = size - 2
    while(i > 0  && input(i) > temp){
      input(i + 1) = input(i)
      println(s"${input.mkString(" ")}")
      i -= 1
    }
    input(i + 1) = temp
    println(s"${input.mkString(" ")}")
  }

  def main(args: Array[String]): Unit = {
     val arraySize = StdIn.readLine().toInt
     val inputArray = StdIn.readLine()
       .split(" ").map(_.toInt)

    insertionSort(arraySize, inputArray)
  }
}
