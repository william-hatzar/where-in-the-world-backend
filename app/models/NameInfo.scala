package models

import play.api.libs.json.{Format, Json}

case class NameInfo(common: String, official: String, nativeName: Option[NativeName])

object NameInfo {

  implicit val format:Format[NameInfo] = Json.format[NameInfo]

}