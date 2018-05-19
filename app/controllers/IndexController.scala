package controllers

import java.io.FileInputStream
import javax.inject._

import models.Category
import play.api.i18n.I18nSupport
import play.api.libs.json.{JsPath, JsValue, Json, Reads}
import play.api.mvc._
import views.html.main

import scala.reflect.io.File

class IndexController @Inject()(val controllerComponents: ControllerComponents
                               ) extends BaseController with I18nSupport {

  def first = Action { implicit request: Request[AnyContent] =>
    val stream = new FileInputStream("/home/madhura/Applications/hmrc-development-environment/hmrc/QuizMaster/app/resources/master.json")
    val json: JsValue = try {  Json.parse(stream) } finally { stream.close() }

    def catReads(index: Int): Reads[Category] = (JsPath \ "categories" \ index).read[Category]

    val categories: Seq[Category] = for (i <- 0 to 1) yield json.validate[Category](catReads(i)).get

    Ok(main("QuizMaster", categories))
  }

}