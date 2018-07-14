package connectors

import com.google.inject.Inject
import javax.inject.Singleton
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json.collection.JSONCollection
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class MongoConnector @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends ReactiveMongoComponents  {

  val collection = reactiveMongoApi.database.map(_.collection[JSONCollection]("categories"))


}
