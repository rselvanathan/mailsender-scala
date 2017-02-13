package com.romeshselvan.mail.producer

import com.romeshselvan.defaults.AppType
import com.romeshselvan.defaults.AppType.ROMCHARM
import com.romeshselvan.mail.MailSenderService
import com.romeshselvan.defaults.AppType
import com.romeshselvan.defaults.AppType.ROMCHARM
import com.romeshselvan.mail.{MailSenderService, RomCharmMailService}
import org.json4s.DefaultFormats
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailSender
import org.springframework.stereotype.Component

/**
  * @author Romesh Selvan
  */
@Component
@Autowired
class MailSenderServiceProducer(m : MailSender) {

  implicit val defaults = DefaultFormats
  val mailSender : MailSender = m

  def apply(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(mailSender)
  }
}
