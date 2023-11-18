package models

import play.api.libs.json.{Format, Json}

case class NameData(official: String, common: String)

object NameData {
  implicit val format: Format[NameData] = Json.format[NameData]
}