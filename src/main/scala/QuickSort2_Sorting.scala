/**
  * QuickSort 2 - Sorting from hackerrank
  * Input: 5,8,1,3,7,9,2
  * Output:
  * 2 3
  * 1 2 3
  * 7 8 9
  * 1 2 3 5 7 8 9
  */

object QuickSort2_Sorting {
  def partition(array: Array[Int], start: Int, end: Int): Int = {
    val pivot = array(start)
    val (left, right) = array.slice(start, end + 1)
      .partition(_ < pivot)

    var temp = start

    for (i <- left.indices) {
      array(temp) = left(i)
      temp += 1
    }

    val npp = start + left.length
    array(npp) = pivot
    temp = npp + 1

    for (j <- 1 until right.length) {
      array(temp) = right(j)
      temp += 1
    }

    npp
  }

  def quickSort(input: Array[Int], start: Int, end: Int): Unit = {
    val pIndex = partition(input, start, end)

    if (start < end) {
      val pIndex = partition(input, start, end)
      quickSort(input, start, pIndex - 1)
      quickSort(input, pIndex + 1, end)
    }

    if ((start to end).size > 1) {
      for (i <- start to end) {
        print(s"${input(i)} ")
      }
      println()
    }
  }
}
