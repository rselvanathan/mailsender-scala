package com.romeshselvan.mailer

import javax.mail.internet.{InternetAddress, MimeMessage}
import javax.mail.{Message, MessagingException, Session, Transport}

import com.typesafe.scalalogging.Logger

/**
  * @author Romesh Selvan
  */
class Mailer(config : MailConfig, session : Session) {

  val logger = Logger("Mailer")

  def send(mailMessage: MailMessage) : Unit = {
    val mimeMessage = new MimeMessage(session)
    copyMessage(mailMessage, mimeMessage)
    val transport = session.getTransport(session.getProperty("mail.transport.protocol"))
    try {
      connectTransport(transport)
      sendMessage(transport, mimeMessage)
    } catch {
      case m: MessagingException => // Swallow Exception
    } finally {
      transport.close()
    }
  }

  @throws(classOf[MessagingException])
  private def connectTransport(transport : Transport): Unit = {
    try {
      transport.connect(config.host, config.port, config.username, config.password)
    } catch {
      case m: MessagingException => logger.error("Error connecting to email endpoint", m); throw m
    }
  }

  @throws(classOf[MessagingException])
  private def sendMessage(transport: Transport, mimeMessage: MimeMessage): Unit = {
    try {
      transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients)
    } catch {
      case m: MessagingException => logger.error("Error sending message", m); throw m
    }
  }

  private def copyMessage(mailMessage: MailMessage, mimeMessage: MimeMessage): Unit = {
    mimeMessage.setFrom(mailMessage.from)
    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailMessage.to))
    mimeMessage.setSubject(mailMessage.subject)
    mimeMessage.setText(mailMessage.text)
  }
}
