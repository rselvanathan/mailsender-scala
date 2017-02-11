package mail.producer

import defaults.ROMCHARM
import mail.{MailSenderService, RomCharmMailService}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSuite, Matchers}
import producers.MailSenderProducer

class MailSenderServiceProducerTest extends FunSuite with Matchers with MockitoSugar {

  val mailSenderProducer : MailSenderProducer = mock[MailSenderProducer]
  val mailSenderServiceProducer : MailSenderServiceProducer = new MailSenderServiceProducer(mailSenderProducer)

  test("When AppType is ROMCHARM return a RomCharmMailService object") {
    val result : MailSenderService = mailSenderServiceProducer.getMailSender(ROMCHARM)
    result should be (a [RomCharmMailService])
  }
}
