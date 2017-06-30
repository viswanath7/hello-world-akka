name := "hello-world-akka"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka"   %% "akka-actor"         % "2.5.3",
  "com.typesafe.akka"   %% "akka-testkit"       % "2.5.3"   % "test",
  "com.typesafe.akka"   %% "akka-slf4j"         % "2.5.3",
  "ch.qos.logback"      % "logback-classic"     % "1.1.7",
  "org.scalactic"       %% "scalactic"          % "3.0.1",
  "org.scalatest"       %% "scalatest"          % "3.0.1"   % "test"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"