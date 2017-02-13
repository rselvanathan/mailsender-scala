package com.romeshselvan.mail.producer

import com.romeshselvan.defaults.AppType
import com.romeshselvan.defaults.AppType.ROMCHARM
import com.romeshselvan.mail.{MailSenderService, RomCharmMailService}
import com.romeshselvan.producers.MailSenderProducer
import org.json4s.DefaultFormats

/**
  * @author Romesh Selvan
  */
trait MailSenderServiceProducer {
  def apply(appType: AppType) : MailSenderService
}

object MailSenderServiceProducer extends MailSenderServiceProducer{

  implicit val defaults = DefaultFormats

  def apply(appType : AppType) : MailSenderService = appType match {
    case ROMCHARM => new RomCharmMailService(MailSenderProducer.mailSender)
  }
}
