package com.romeshselvan.mail.producer

import com.romeshselvan.defaults.AppType
import com.romeshselvan.defaults.AppType.ROMCHARM
import com.romeshselvan.mail.{MailSenderService, RomCharmMailService}
import com.romeshselvan.producers.MailerProducer

/**
  * @author Romesh Selvan
  */
trait MailSenderServiceProducer {

  def apply(appType: AppType) : MailSenderService
}

object MailSenderServiceProducer extends MailSenderServiceProducer{

  def apply(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(MailerProducer.mailSender)
  }
}
