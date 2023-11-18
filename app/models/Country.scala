package models

import play.api.libs.json.{Format, Json}

case class Country(name: NameInfo,
                   tld : Seq[String],
                   cca2: String,
                   ccn3: String,
                   cca3: String,
                   cioc: String,
                   independent: Boolean,
                   status : String,
                   unMember : Boolean,
                   currencies : Currencies,
                   idd: Idd,
                   capital: Seq[String],
                   altSpellings: Seq[String],
                   region: String,
                   subregion: String,
                   languages: Languages,
                   translations: Translations,
                   latlng: Seq[Double],
                   landlocked: Boolean,
                   borders: Seq[String],
                   area: Double,

                   )

object Country {
  implicit val format:Format[Country] = Json.format[Country]
}