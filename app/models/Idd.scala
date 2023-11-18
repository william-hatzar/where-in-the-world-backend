package models

import play.api.libs.json.{Format, Json}

case class Idd(root: String, suffixes: Seq[String])

object Idd {

  implicit val format:Format[Idd] = Json.format[Idd]

}
