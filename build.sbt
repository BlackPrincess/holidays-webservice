name := "holidays-webservice"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    "jp.t2v" %% "holidays" % "3.0-SNAPSHOT",
    "org.scalaz" %% "scalaz-core" % "7.0.6"
)

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

play.Project.playScalaSettings
