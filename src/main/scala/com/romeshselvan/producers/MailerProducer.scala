package com.romeshselvan.producers

import java.util.Properties
import javax.mail.Session

import com.romeshselvan.defaults.SystemValues
import com.romeshselvan.mailer.{MailConfig, Mailer}

/**
  * @author Romesh Selvan
  */
object MailerProducer {

  val mailSender = {
    val prop = new Properties()
    prop.put("mail.transport.protocol", "smtp")
    prop.put("mail.smtp.starttls.enable", "true")
    val config = MailConfig(SystemValues.MAIL_HOST, SystemValues.MAIL_PORT.toInt, SystemValues.MAIL_USERNAME, SystemValues.MAIL_PASSWORD, tlsEnabled = true)
    new Mailer(config, Session.getInstance(prop))
  }
}
