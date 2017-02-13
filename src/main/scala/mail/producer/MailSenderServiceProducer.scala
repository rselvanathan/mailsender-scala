package mail.producer

import com.google.inject.Inject
import defaults.AppType
import defaults.AppType.ROMCHARM
import mail.{MailSenderService, RomCharmMailService}
import org.json4s.DefaultFormats
import org.springframework.mail.MailSender

/**
  * @author Romesh Selvan
  */
@Inject
class MailSenderServiceProducer(m : MailSender) {

  implicit val defaults = DefaultFormats
  val mailSender : MailSender = m

  def apply(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(mailSender)
  }
}
