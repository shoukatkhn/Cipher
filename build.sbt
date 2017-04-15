name := "Cipher"
version := "1.0"
scalaVersion := "2.11.7"
libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",
  "org.apache.spark" % "spark-sql_2.11" % "1.6.1",
  "com.github.scopt" % "scopt_2.11" % "3.4.0",
  "org.specs2" %% "specs2-core" % "3.7" % "test",
  "org.specs2" %% "specs2-junit" % "3.7" % "test",
  "org.specs2" % "specs2_2.11" % "3.7"
)
        