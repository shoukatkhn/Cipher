/**
  * The member states of the UN are planning to send 2 people to the Moon. But there is a problem.
  * In line with their principles of global unity, they want to pair astronauts of 2 different countries.
  * There are N trained astronauts numbered from 0 to N - 1. But those in charge of the mission did not
  * receive information about the citizenship of each astronaut. The only information they have is that
  * some particular pairs of astronauts belong to the same country. Your task is to compute in how many
  * ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided
  * enough pairs to let you identify the groups of astronauts even though you might not know their country directly.
  * For instance, if 1,2,3 are astronauts from the same country; it is sufficient to mention that (1,2) and (2,3)
  * are pairs of astronauts from the same country without providing information about a third pair (1,3).
  **/


import scala.io.StdIn

object JourneyToTheMoon {
  def connected(v: Set[Int], visited: Array[Boolean], graph: Map[Int, Set[Int]]): Set[Int] = {
    v.foreach {
      e =>
        if (!visited(e)) {
          visited(e) = true
          connected(graph(e),visited,graph)
        }
    }
    /*solution is count all visited for v and create a set*/
    Set(visited.count(_ == true))
  }


  def main(args: Array[String]): Unit = {
    val Array(total, numOfCountries) = StdIn.readLine().
      split(" ").map(_.toInt)

    /*
    * input = {(0,1),(2,3),(4,0),(1,2),(5,6)}
    * */

    var graph = (0 until total).map{ a => a -> Set.empty[Int]}.toMap

    /* graph: total = 7
    (0,Set(1, 4))
    (5,Set(6))
    (1,Set(0, 2))
    (6,Set(5))
    (2,Set(3, 1))
    (3,Set(2))
    (4,Set(0))
    * */

    for (i <- 0 until numOfCountries) {
      val Array(a, b) = StdIn.readLine().split(" ").map(_.toInt)
      graph match {
        case x if x.contains(a) =>
          val c = graph(a) ++: Set(b)
          val d = graph(b) ++: Set(a)
          graph ++= Map(a -> c)
          graph ++= Map(b -> d)

        case _ =>
      }
    }

   /*
   * output should look like
   *  0 -- 1 -- 4
   *       |
   *       2 -- 3
   *  5 -- 6
   *  {0,1,2,4,3},{5,6}
   * */

    var eo: Set[Set[Int]] = Set.empty

    graph.filter(_._2.nonEmpty).foreach {
      elem =>
        if (eo.flatten.intersect(Set(elem._1)).isEmpty)
          eo += connected(Set(elem._1), new Array[Boolean](total), graph)
    }

    graph.filter(_._2.isEmpty).foreach {
      elem =>
        eo += Set(elem._1)
    }


    /*
    * old answer + (sum of old values * new value)
    * */

    var sum = 0
    var product = 0

    eo.foreach {
      f =>
        product += (sum * f.size)
        sum += f.size
    }

    println(product)
  }
}
