package controllers

import java.io.FileInputStream
import javax.inject.Inject

import play.api.Configuration
import play.api.i18n.I18nSupport
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{BaseController, ControllerComponents}

class ParentController @Inject()(val controllerComponents: ControllerComponents,
                                 implicit val config: Configuration
                                ) extends BaseController with I18nSupport {


  val stream = new FileInputStream(config.get[String]("json.path"))
  lazy val json: JsValue = try {  Json.parse(stream) } finally { stream.close() }

}
