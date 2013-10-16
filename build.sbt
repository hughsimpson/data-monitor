/** Project */
name := "Data Monitor"

version := "0.0.1"

scalaVersion := "2.10.3"

/** Dependencies */
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies <<= scalaVersion { scala_version =>
    val akkaVersion  = "2.2.0"
    Seq(
        "com.typesafe.akka"     %% "akka-actor"             % akkaVersion,
        "org.aspectj"           % "aspectjweaver"           % "1.7.2",
        "org.aspectj"           % "aspectjrt"               % "1.7.2",
        "com.indeed"            % "java-dogstatsd-client"   % "2.0.7"
    )
}

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

parallelExecution in Test := false

javaOptions in run += "-javaagent:" + System.getProperty("user.home") + "/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.7.2.jar"

fork in run := true

connectInput in run := true