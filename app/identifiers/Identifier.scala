package identifiers

import play.api.libs.json.{JsPath, _}

trait Identifier {

  def path: JsPath = __ \ toString

}

object Identifier {
  implicit def toString(i: Identifier): String = i.toString
}

object TypedIdentifier{
  trait PathDependent extends Identifier {
    type Data
  }
}

trait TypedIdentifier[A] extends TypedIdentifier.PathDependent{
  type Data = A
}
