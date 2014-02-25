import sbt._
import sbt.Keys._

object MyBuild extends Build {

  val core = Project("my-application-core", file("my-application-core"))
    .settings(
      version := Pom.version(baseDirectory.value),
      libraryDependencies ++= Pom.dependencies(baseDirectory.value))

  val root = play.Project("my-application-play", path = file("my-application-play"))
    .dependsOn(core)
    .settings(
      version := Pom.version(baseDirectory.value),
      libraryDependencies ++= Pom.dependencies(baseDirectory.value).filterNot(d => d.name == core.id))

  override def rootProject = Some(root)
}