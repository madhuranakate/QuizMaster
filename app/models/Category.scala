package models

import play.api.libs.json.{JsPath, Json, Reads}

case class Category(name: String, desc: Option[String], quizzes: Seq[Quiz], link: String)

object Category {
  implicit val format = Json.format[Category]
  implicit def catReads(index: Int): Reads[Category] = (JsPath \ "categories" \ index).read[Category]

}