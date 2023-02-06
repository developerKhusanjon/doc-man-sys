ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "doc-man-sys",
    libraryDependencies ++= {
      val akkaVersion = "2.7.0"
      val akkaHttpVersion = "10.4.0"
      val slickVersion = "3.4.1"
      Seq(
        "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
        "com.typesafe.akka" %% "akka-stream" % akkaVersion,

        "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
        "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
        "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
        "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,

        "com.typesafe.slick" %% "slick" % slickVersion,
        "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
      )
    }
  )
