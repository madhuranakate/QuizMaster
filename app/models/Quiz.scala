package models

import play.api.libs.json.Json

case class Quiz(name: String, link: String)

object Quiz {
  implicit val format = Json.format[Quiz]
}
