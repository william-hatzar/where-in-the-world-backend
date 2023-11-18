package models

import play.api.libs.json.{Format, JsObject, JsSuccess, JsValue, Json, Reads, Writes}

case class NativeName(translations: Map[String, NameData])

object NativeName {
  implicit val reads: Reads[NativeName] = (json: JsValue) => {
    val translations = json
      .as[Map[String, JsObject]]
      .view.mapValues(_.as[NameData])

    JsSuccess(NativeName(translations.toMap))
  }

  implicit val writes: Writes[NativeName] = (nativeName: NativeName) => {
    val translationsJson = nativeName.translations.map {
      case (lang, nameData) => lang -> Json.toJson(nameData)
    }
    JsObject(translationsJson.toSeq)
  }

  implicit val format: Format[NativeName] = Format(reads, writes)
}