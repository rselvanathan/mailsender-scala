package mail.producer

import defaults.{AppType, ROMCHARM}
import mail.{MailSenderService, RomCharmMailService}
import producers.MailSenderProducer

/**
  * @author Romesh Selvan
  */
object MailSenderServiceProducer {

  def getMailSender(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(MailSenderProducer.produceMailSender)
  }
}
