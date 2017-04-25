/**
  * QuickSort
  */

object QuickSort {

  def quickSort(xs: Array[Int]): Array[Int] = {
    xs.length < 2 match {
      case true => xs
      case false => {
        val pivot = xs(0)
        quickSort(xs filter (pivot > _)) ++ Array(pivot) ++ quickSort(xs filter (pivot < _))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(5,8,1,3,7,9,2)
    quickSort(array)
  }
}
