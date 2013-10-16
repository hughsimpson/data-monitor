/** Project */
name := "Data Monitor"

version := "0.0.2"

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

/* You might have to change this, I guess, if there's something weird going on with your ivy cache */
javaOptions in run += "-javaagent:" + System.getProperty("user.home") + "/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.7.2.jar"

/* We can't apply the akka actor aspect in the same VM as sbt... */
fork in run := true

/* For the main class readline trickery */
connectInput in run := true