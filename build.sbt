name := "QuizMaster"

version := "1.0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

val buildVersion = "0.13.0-play26"

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-iteratees" % "2.6.1",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.4",
  "org.reactivemongo" %% "play2-reactivemongo" % buildVersion
)
    
