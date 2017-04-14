package Cipher
/**
  * given two paths find outs what are the files missing, but check subdirectories as well
  * ex: /home/foo/
    a
    b
    d1/
      a
      x
        d2/
            y
            z
    d3/

      /tmp/bar/
      a
      cc
      q
      d1/
        a
        zz
          d2/
            y
            z
      d4/
        hi
      b/
  */

import java.io.File
object MissingFiles {
  def diffDir(path1: String, path2: String): Unit = {
    var res: List[String] = List.empty

    def resourcesInPath(path: String): Unit = new File(path).listFiles.foreach {
      case x if x.isFile => res ++= List(x.getParent ++ "/" ++ x.getName)
      case y if y.isDirectory => resourcesInPath(y.getPath)
      case _ =>
    }

    resourcesInPath(path1)
    resourcesInPath(path2)

    res.flatMap(_.split("/").last).foldLeft(Map.empty[Char, Int]) {
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
    }.filter(_._2 == 1).foreach(println)
  }
}
