import org.apache.spark.{SparkContext, SparkConf}
import org.specs2.mutable.Specification

class TestTrueMotion extends Specification {
  val conf = new SparkConf()
    .setAppName("TrueMotion")
    .set("spark.driver.allowMultipleContexts","true")
    .setMaster("local")

  val sc = new SparkContext(conf)

  "true motion" should {

    "run" in {
      val opts = TrueMotion.Opts(input = "src/test/resources/user0.json,src/test/resources/user1.json,src/test/resources/user2.json"
        ,partitions = 10)

      TrueMotion.worker(sc,opts)

      ok
    }
  }
}
