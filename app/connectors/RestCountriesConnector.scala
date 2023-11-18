package connectors

import models.Country

import scala.concurrent.{ExecutionContext, Future}
import play.api.libs.ws.{WSClient, WSResponse}
import play.api.http.Status
import play.api.libs.json.{JsError, JsSuccess, Reads}

import javax.inject.Inject

class RestCountriesConnector @Inject()(http: WSClient) {

  def getData(name: String)(implicit executionContext: ExecutionContext): Future[List[Country]] =
    http.url(s"https://restcountries.com/v3.1/name/$name").get().flatMap { response =>
      response.status match {
        case Status.OK =>
          response.json.validate[List[Country]] match {
            case JsSuccess(value, _) => Future.successful(value)
            case JsError(errors) =>
              println(s"Failed to parse JSON: $errors")
              Future.successful(List.empty[Country])
          }
        case status =>
          println(s"Request failed with status: $status")
          Future.successful(List.empty[Country])
      }
    }.recover {
      case ex: Exception =>
        println(s"An error occurred: ${ex.getMessage}")
        List.empty[Country]
    }
}
