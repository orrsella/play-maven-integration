import sbt._
import scala.xml.XML
import scala.language.postfixOps

object Pom {
  private val prefix = "[INFO]    "

  def version(pomDir: File): String = {
    val pom = new File(pomDir, "pom.xml")
    val xml = XML.loadFile(pom)
    val version = (xml \\ "project" \ "version").text
    version
  }

  def dependencies(pomDir: File): Seq[ModuleID] = {
    val list = (Process("mvn dependency:list", pomDir) !!)
    val lines = list.split("\n").collect {
      case line if (line.startsWith(prefix)) => line.replace(prefix, "").trim
    }
    lines.map(parse).collect { case Some(dep) => dep }
  }

  private def parse(line: String): Option[ModuleID] = {
    val parts = line.split(":")

    if (parts.size < 4) None
    else {
      val groupId = parts(0)
      val artifactId = parts(1)
      val revision = parts(parts.size - 2)
      val configuration = parts.last
      val dependency = (groupId % artifactId % revision % configuration) intransitive()

      if (parts.size > 5) {
        val cls = parts(parts.size - 3)
        Some(dependency classifier cls)
      } else Some(dependency)
    }
  }
}