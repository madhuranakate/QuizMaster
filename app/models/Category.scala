package models

import play.api.libs.json._

case class Category(name: String, desc: Option[String], quizzes: Seq[Quiz], link: String)

object Category {
  implicit val format = Json.format[Category]

}