package models

import play.api.libs.json.{JsObject, JsSuccess, JsValue, Json, Reads, Writes}

case class Currencies(currencyData: Map[String, CurrencyInfo])

object Currencies {
  implicit val reads: Reads[Currencies] = (json: JsValue) => {
    val currencyData = json
      .as[Map[String, JsObject]]
      .view.mapValues(_.as[CurrencyInfo])

    JsSuccess(Currencies(currencyData.toMap))
  }

  implicit val writes: Writes[Currencies] = Json.writes[Currencies]
}
