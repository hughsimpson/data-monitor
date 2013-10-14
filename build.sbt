/** Project */
name := "Data Monitor"

version := "0.0.1"

scalaVersion := "2.10.2"

/** Dependencies */
resolvers += "Cakesolutions Artifactory Releases" at "http://build.cakesolutions.net/artifactory/all-releases/"

resolvers += "snapshots-repo" at "http://scala-tools.org/repo-snapshots"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies <<= scalaVersion { scala_version =>
    val sprayVersion = "1.1-20130207"
    val akkaVersion  = "2.1.0"
    val scalazVersion = "7.0.0-M8"
    Seq(
           "com.typesafe.akka"      %% "akka-actor"            % akkaVersion,
           "com.typesafe.akka"      %% "akka-dataflow"         % akkaVersion,
           "com.typesafe.akka"      %% "akka-kernel"           % akkaVersion,
           "commons-codec"           % "commons-codec"         % "1.4",
           "commons-io"              % "commons-io"            % "2.4",
         "org.scala-lang"          % "scala-reflect"         % "2.10.0",
        "org.aspectj" % "aspectjweaver" % "1.7.2",
        "org.aspectj" % "aspectjrt"     % "1.7.2"
    )
}

/** Compilation */
javaOptions += "-Xmx2G"

scalacOptions ++= Seq("-deprecation", "-unchecked")

maxErrors := 20 

pollInterval := 1000

logBuffered := false

cancelable := true