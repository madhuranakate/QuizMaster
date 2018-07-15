package controllers

import connectors.MongoConnector
import javax.inject._
import models.Category
import play.api.Configuration
import play.api.mvc._
import views.html.home
import scala.concurrent.ExecutionContext.Implicits.global


class HomeController @Inject()(val cc: ControllerComponents,
                               config: Configuration,
                               dbConn: MongoConnector,
                              ) extends ParentController(cc, config) {

  def onPageLoad = Action.async {
    implicit request: Request[AnyContent] =>

      dbConn.save("quizzy", json)
      dbConn.fetch("quizzy").map { jsonz =>
        val cat = (jsonz \ "categories").as[Seq[Category]]
        Ok(home(cat))
      }
  }

}