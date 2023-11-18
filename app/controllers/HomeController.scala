package controllers

import connectors.RestCountriesConnector

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, connector: RestCountriesConnector) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def getCountryInformation(countryName: String): Action[AnyContent] = Action.async {
    connector.getData(countryName).map { response =>
      Ok(Json.toJson(response))
    }
  }

}
