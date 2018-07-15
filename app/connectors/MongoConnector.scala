package connectors

import com.google.inject.Inject
import javax.inject.Singleton
import play.api.libs.json.{JsValue, Json}
import play.modules.reactivemongo.{ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json._
import reactivemongo.play.json.collection.{JSONCollection, _}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class MongoConnector @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends ReactiveMongoComponents  {


  def collection = reactiveMongoApi.database.map(_.collection[JSONCollection]("categories"))

  def save(id: String, json: JsValue): Future[Boolean] = {

    val document = Json.obj(
      "id" -> id,
      "data" -> json
    )

    val selector = Json.obj("id" -> id)
    val modifier = Json.obj("$set" -> document)

    collection.flatMap(_.update(selector, modifier, upsert = true))
      .map(_.ok)
  }

  def get(id: String): Future[Option[JsValue]] = {
    import play.api.libs.json._
    collection.flatMap(_.find(Json.obj("id" -> id)).one[JsObject].map {
      json =>
        json.flatMap {
          json =>
            json.validate((__ \ "data").json.pick[JsObject]).asOpt
        }
    })
  }

  def fetch(id: String) = {
    get(id).map {
      case None => throw new JSONException("Json returned null")
      case Some(data) => data
    }
  }

}
