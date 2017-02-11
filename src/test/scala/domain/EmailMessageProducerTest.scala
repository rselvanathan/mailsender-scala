package domain

import defaults.{AppType, ROMCHARM}
import org.scalatest.{FunSuite, Matchers}

class EmailMessageProducerTest extends FunSuite with Matchers {

  val EMAIL : String = "romesh@hotmail.com"
  val FIRSTNAME : String = "romesh"
  val LASTNAME : String = "selvan"
  val AREATTENDING : Boolean = true
  val NUMBERATTENDING : Int = 2

  val emailMessageProducer : EmailMessageProducer = new EmailMessageProducer

  test("If AppType is RomCharm then return a RomCharmEmail Object with all the fields mapped correctly") {

    val json : String = getDefaultRomCharmJson
    val appType : AppType = ROMCHARM
    val expected : RomCharmEmail = getDefaultRomCharmMailObject

    val emailMessage : Email = emailMessageProducer.produceEmailMessage(appType, json)

    emailMessage should be (a [RomCharmEmail])
    val result = emailMessage.asInstanceOf[RomCharmEmail]
    result shouldEqual expected
  }

  private def getDefaultRomCharmMailObject : RomCharmEmail = {
    RomCharmEmail(EMAIL, FIRSTNAME, LASTNAME, AREATTENDING, NUMBERATTENDING)
  }

  private def getDefaultRomCharmJson : String = {
    s"""{"email": "$EMAIL", "firstName" : "$FIRSTNAME", "lastName" : "$LASTNAME", "areAttending" : $AREATTENDING, "numberAttending" : $NUMBERATTENDING}"""
  }
}
