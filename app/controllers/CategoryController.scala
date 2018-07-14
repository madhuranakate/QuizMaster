package  controllers

import javax.inject._
import play.api.Configuration
import play.api.mvc._
import play.modules.reactivemongo.ReactiveMongoApi
import views.html.category

class CategoryController @Inject()(val cc: ControllerComponents, config: Configuration, reactiveMongoApi: ReactiveMongoApi) extends ParentController(cc, config) {

  def onPageLoad(name: String) = Action {
    implicit request: Request[AnyContent] =>
      Ok(category())
  }

}