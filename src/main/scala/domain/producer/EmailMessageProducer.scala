package domain.producer

import defaults.AppType
import defaults.AppType.ROMCHARM
import domain.{Email, RomCharmEmail}
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._

/**
  * @author Romesh Selvan
  */
object EmailMessageProducer {

  implicit val defaults = DefaultFormats

  def apply(appType : AppType, jString : JValue) : Email = appType match {
    case ROMCHARM =>
      val jValue : JValue = parse(jString.extract[String])
      jValue.extract[RomCharmEmail]
  }
}
