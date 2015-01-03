import com.typesafe.sbt.SbtStartScript
import spray.revolver.RevolverPlugin.Revolver

organization  := "example"

name          := "application_name"

version       := "1.0"

scalaVersion  := "2.11.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers     ++= Seq(
  "spray" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.3.6"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"                  %   "spray-can"                 % sprayV withSources(),
    "io.spray"                  %   "spray-routing"             % sprayV withSources(),
    "io.spray"                  %   "spray-client"              % sprayV withSources(),
    "io.spray"                  %   "spray-caching"             % sprayV withSources(),
    "io.spray"                  %%  "spray-json"                % "1.3.1" withSources(),
    "io.spray"                  %   "spray-testkit"             % sprayV  % "test",
    "com.typesafe.akka"         %%  "akka-actor"                % akkaV withSources(),
    "com.typesafe.akka"         %%  "akka-testkit"              % akkaV % "test",
    "org.specs2"                %%  "specs2-core"               % "2.4.15" % "test"
  )
}

SbtStartScript.startScriptForClassesSettings

Revolver.settings

Revolver.reColors := Seq("magenta")
