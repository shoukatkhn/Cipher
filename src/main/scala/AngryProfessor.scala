/**
    * A Discrete Mathematics professor has a class of N students. Frustrated with their lack of discipline,
    * he decides to cancel class if fewer than K students are present when class starts.
    * Given the arrival time of each student, determine if the class is canceled.
  */

import scala.io.StdIn
object AngryProfessor {
  def compute(minStudents: Int, timmings: Array[Int]): Unit = {
    if (timmings.count(_ <= 0) >= minStudents) println("NO") else println("YES")
  }

  def main(args: Array[String]): Unit = {
     val numOfLines = StdIn.readLine().toInt
     for (i <- 1 to numOfLines) {
       val Array(total,min) = StdIn.readLine().split(" ").map(_.toInt)
       val timing = StdIn.readLine().split(" ").map(_.toInt)
       compute(min, timing)
     }
  }
}
