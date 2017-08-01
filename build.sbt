organization := "com.example"
name := "Scalatra Atmosphere Example"
version := "0.1.0-SNAPSHOT"


// forced to use scala 2.11, as that's what spark requires

//scalaVersion := "2.12.2"
scalaVersion := "2.11.1"


// these Scalatra dependencies work in isolation (without Spark), on scala v2.12.2

//val ScalatraVersion = "2.5.+"
//libraryDependencies ++= Seq(
//  "org.json4s"                  %% "json4s-jackson"      % "3.5.2",
//  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
//  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
//  "org.scalatra"                %% "scalatra-specs2"     % ScalatraVersion    % "test",
//  "org.scalatra"                %% "scalatra-atmosphere" % ScalatraVersion,
//  "org.eclipse.jetty"           %  "jetty-webapp"        % "9.4.6.v20170531"  % "provided",
//  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"            % "provided"
//)
//enablePlugins(JettyPlugin)


// these Spark dependencies work in isolation (without Scalatra), on scala v2.11.1

val sparkVersion = "2.2.0"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-kafka-0-8" % sparkVersion
)


// spark *requires* scala 2.11, so here I replace all Scalatra dependencies with their v2.11 versions

val ScalatraVersion = "2.5.1"
libraryDependencies ++= Seq(
  "org.json4s"                  %% "json4s-jackson"      % "3.5.3",
  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
  "org.scalatra"                %% "scalatra-specs2"     % ScalatraVersion    % "test",
  "org.scalatra"                %% "scalatra-atmosphere" % ScalatraVersion,

  // for the jetty and javax servlet dependencies, I referenced an older Scalatra example that used Scala 2.11
  // choosing versions according to that example:
  // // (https://github.com/scalatra/scalatra-website-examples/tree/master/2.3/async/scalatra-atmosphere-example)
  "org.eclipse.jetty"           %  "jetty-webapp"        % "9.1.3.v20140225"  % "provided",
  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"            % "provided"
)
enablePlugins(JettyPlugin)