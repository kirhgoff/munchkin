name := "munchkin"

organization := "org.kirhgoff"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
    "org.scalatest"   %% "scalatest"    % "2.2.4"   % "test",
    "org.scalacheck"  %% "scalacheck"   % "1.12.5"      % "test",
    "ch.qos.logback"  %  "logback-classic"   % "1.1.3"
)

scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")

javaOptions += "-Xmx4G"






