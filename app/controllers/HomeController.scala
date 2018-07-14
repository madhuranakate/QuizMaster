package controllers

import javax.inject._
import models.Category
import models.Category.catReads
import play.api.Configuration
import play.api.mvc._
import views.html.home

class HomeController @Inject()(val cc: ControllerComponents,
                               config: Configuration
                              ) extends ParentController(cc, config) {

  def onPageLoad = Action {
    implicit request: Request[AnyContent] =>
        println(request.body)
      val categoryList: Seq[Category] =
        for (i <- 0 to 1)
          yield {
            json.validate[Category](catReads(i)).get
          }



      Ok(home(categoryList))
  }

}