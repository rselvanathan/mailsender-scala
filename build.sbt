name := "mailsender-scala"

organization := "com.romeshselvan"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.1"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-mail" % "1.4.3.RELEASE"
libraryDependencies += "javax.mail" % "javax.mail-api" % "1.5.6"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-sqs" % "1.11.78"
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"