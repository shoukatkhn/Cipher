/**
    * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height.
    * Each summer, its height increases by 1 meter. Laura plants a Utopian Tree sapling with a height
    * of 1 meter at the onset of spring. How tall will her tree be after N growth cycles?
  */

import scala.io.StdIn
object UtopianTree {
  def findHeight(numOfCycles: Int): Unit = {
    var height: Int = 1
    (1 to numOfCycles).foreach {
      case x if x % 2 != 0 => height *= 2
      case x if x % 2 == 0 => height += 1
    }
    println(height)
  }

  def main(args: Array[String]): Unit = {
     val numOfArgs = StdIn.readLine().toInt
     for (i <- 1 to numOfArgs) {
       findHeight(StdIn.readLine().toInt)
     }
  }
}
