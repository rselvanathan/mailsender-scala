package domain

import defaults.{AppType, ROMCHARM}
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._

/**
  * @author Romesh Selvan
  */
class EmailMessageProducer {

  implicit val defaults = DefaultFormats

  def produceEmailMessage(appType : AppType, rawJsonMessage : String) : Email = appType match {
    case ROMCHARM =>
      val jValue : JValue = parse(rawJsonMessage)
      jValue.extract[RomCharmEmail]
  }
}
