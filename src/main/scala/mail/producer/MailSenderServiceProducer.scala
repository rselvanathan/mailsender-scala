package mail.producer

import com.google.inject.Inject
import defaults.{AppType, ROMCHARM}
import mail.{MailSenderService, RomCharmMailService}
import producers.MailSenderProducer

/**
  * @author Romesh Selvan
  */
@Inject
class MailSenderServiceProducer(m : MailSenderProducer) {

  val mailSenderProducer : MailSenderProducer = m

  def getMailSender(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(mailSenderProducer.produceMailSender)
  }
}
