package Cipher
/**
  * in insertion sort part 1, you sorted one element into an array. using the same approach repeatedly,
  * can you sort an entire unsorted array? guideline: you already can place an element into a sorted array.
  * how can you use that code to build up a sorted array, one element at a time? note that in the first step,
  * when you consider an array with just the first element - that is already "sorted" since there's nothing
  * to its left that is smaller. in this challenge, don't print every time you move an element. instead, print
  * the array after each iteration of the insertion-sort, i.e., whenever the next element is placed at its correct
  * position. since the array composed of just the first element is already "sorted", begin printing from the second
  * element and on.
  */

import scala.io.StdIn
object InsertionSortPart2 {

  def iSort(input: Array[Int]): Array[Int] = {
    for (i <- 1 until input.length) {
      val elem = input(i)
      for (j <- i - 1 to 0 by - 1) {
        if (elem < input(j)) {
          input(j + 1) = input(j)
          input(j) = elem
        }
      }
    }
    input
  }

  def main(args: Array[String]): Unit = {
     val size = StdIn.readLine().toInt
     val array = StdIn.readLine().split(" ").map(_.toInt)
     iSort(array)
  }
}
