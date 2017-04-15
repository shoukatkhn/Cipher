import org.apache.spark._
import org.apache.spark.sql.{DataFrame, SQLContext}
import scopt.OptionParser

object TimeSeriesUsingSpark {
  val conf = new SparkConf()
    .setAppName("TimeSeriesUsingSpark")
    .set("spark.driver.allowMultipleContexts","true")
    .setMaster("local")

  val sc = new SparkContext(conf)

  val sqlContext = new SQLContext(sc)

  case class Opts(input: String = "", partitions: Int = 10)

  val parser = new OptionParser[Opts]("scopt") {
    head("TimeSeriesUsingSpark", "SNAPSHOT")

    opt[Int]("count") required() action {
      (x, c) =>
        c.copy(partitions = x)
    } text "Num of files in user folder"

    opt[String]("input") required() action {
      (x,c) =>
        c.copy(input = x)
    } text "Pass the filenames seperated by comma ex file1,file2"
  }

  def worker(sparkContext: SparkContext, opts: Opts): Unit = {
    implicit val isc = sparkContext

    //creating DataFrames for each file and using schema partitioning
    opts.input.split(",").foreach {
      fn =>
        val getUserName = fn.split("/")
        val df = sqlContext.read.json(fn)
        df.write.parquet(s"target/data/test_table/key=${getUserName(getUserName.length - 1).stripSuffix(".json")}")
    }

    val finalDF = sqlContext.read.option("mergeSchema","true").parquet("target/data/test_table")
    print(finalDF.show)
    print(finalDF.printSchema())
  }

  def main(args: Array[String]) {
    val opts = parser.parse(args, Opts()).get
      worker(sc,opts)
  }
}
