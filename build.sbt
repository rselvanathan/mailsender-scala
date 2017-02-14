name := "mailsender-scala"

organization := "com.romeshselvan"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.1"

libraryDependencies += "javax.mail" % "javax.mail-api" % "1.5.6"
libraryDependencies += "com.sun.mail" % "javax.mail" % "1.5.6"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-sqs" % "1.11.78"
libraryDependencies += "org.json4s" % "json4s-native_2.12" % "3.5.0"
libraryDependencies += "com.beachape" % "enumeratum_2.12" % "1.5.7"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"

// Test
libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5" % "test"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.0" % "test"
libraryDependencies += "org.scalamock" % "scalamock-scalatest-support_2.12" % "3.5.0" % "test"