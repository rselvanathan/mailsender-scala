package com.romeshselvan.mail.producer

import java.util.Properties

import com.romeshselvan.defaults.AppType.ROMCHARM
import com.romeshselvan.mail.{MailSenderService, RomCharmMailService}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

import scala.io.Source.fromURL

class MailSenderServiceProducerTest extends FunSuite with Matchers with MockFactory with BeforeAndAfterAll {

  override def beforeAll() {
    val properties = new Properties()
    properties.load(fromURL(getClass.getResource("/test.properties")).bufferedReader())
    properties.entrySet().forEach(entry => sys.props.put(entry.getKey.toString, entry.getValue.toString))
  }

  test("When AppType is ROMCHARM return a RomCharmMailService object") {
    val result : MailSenderService = MailSenderServiceProducer(ROMCHARM)
    result should be (a [RomCharmMailService])
  }
}
