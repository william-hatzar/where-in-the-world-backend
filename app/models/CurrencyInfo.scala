package models

import play.api.libs.json.{Format, Json}

case class CurrencyInfo(name: String, symbol: String)

object CurrencyInfo{

  implicit val format:Format[CurrencyInfo] = Json.format[CurrencyInfo]

}
