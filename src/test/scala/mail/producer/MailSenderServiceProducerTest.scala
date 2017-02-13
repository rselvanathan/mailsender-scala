package mail.producer

import defaults.AppType.ROMCHARM
import mail.{MailSenderService, RomCharmMailService}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSuite, Matchers}
import org.springframework.mail.MailSender

class MailSenderServiceProducerTest extends FunSuite with Matchers with MockFactory {

  val mailSenderProducer : MailSender = stub[MailSender]
  val mailSenderServiceProducer : MailSenderServiceProducer = new MailSenderServiceProducer(mailSenderProducer)

  test("When AppType is ROMCHARM return a RomCharmMailService object") {
    val result : MailSenderService = mailSenderServiceProducer(ROMCHARM)
    result should be (a [RomCharmMailService])
  }
}
