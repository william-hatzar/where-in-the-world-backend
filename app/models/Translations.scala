package models

import play.api.libs.json._

case class Translations(translations: Map[String, NameData])

object Translations {
  implicit val reads: Reads[Translations] = (json: JsValue) => {
    val translations = json
      .as[Map[String, JsObject]]
      .view.mapValues(_.as[NameData])

    JsSuccess(Translations(translations.toMap))
  }

  implicit val writes: Writes[Translations] = Json.writes[Translations]
}
