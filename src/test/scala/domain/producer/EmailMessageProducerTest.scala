package domain.producer

import defaults.AppType
import defaults.AppType.ROMCHARM
import domain.{Email, RomCharmEmail}
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._
import org.scalatest.{FunSuite, Matchers}

class EmailMessageProducerTest extends FunSuite with Matchers {

  val EMAIL : String = "romesh@hotmail.com"
  val FIRSTNAME : String = "romesh"
  val LASTNAME : String = "selvan"
  val AREATTENDING : Boolean = true
  val NUMBERATTENDING : Int = 2

  test("If AppType is RomCharm then return a RomCharmEmail Object with all the fields mapped correctly") {

    val json : JValue = parse(getDefaultRomCharmJson)
    val appType : AppType = ROMCHARM
    val expected : RomCharmEmail = getDefaultRomCharmMailObject

    val emailMessage : Email = EmailMessageProducer(appType, json \ "Message")

    emailMessage should be (a [RomCharmEmail])
    val result = emailMessage.asInstanceOf[RomCharmEmail]
    result shouldEqual expected
  }

  private def getDefaultRomCharmMailObject : RomCharmEmail = {
    RomCharmEmail(EMAIL, FIRSTNAME, LASTNAME, AREATTENDING, NUMBERATTENDING)
  }

  private def getDefaultRomCharmJson : String = {
    s"""{"Message":"{\\\"email\\\":\\\"$EMAIL\\\",\\\"firstName\\\":\\\"$FIRSTNAME\\\",\\\"lastName\\\":\\\"$LASTNAME\\\",\\\"areAttending\\\":$AREATTENDING,\\\"numberAttending\\\":$NUMBERATTENDING}"}"""
  }
}
