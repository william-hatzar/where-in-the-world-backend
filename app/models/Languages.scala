package models

import play.api.libs.json._

case class Languages(language: Map[String, String])

object Languages {
  implicit val format: Format[Languages] = new Format[Languages] {
    override def reads(json: JsValue): JsResult[Languages] = {
      val languageMap = json
        .as[Map[String, String]]
        .map { case (key, value) => key.toLowerCase -> value }

      JsSuccess(Languages(languageMap))
    }

    override def writes(o: Languages): JsValue = Json.toJson(o.language)
  }
}