name := "holidays-webservice"

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).dependsOn(yamanohiVer)

lazy val yamanohiVer = uri("git://github.com/t2v/holidays#8bd60a8854874cbeccfe68ca9eb75d02b9fe43b3")

play.Project.playScalaSettings
