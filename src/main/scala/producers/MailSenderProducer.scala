package producers

import java.util.Properties

import com.google.inject.{AbstractModule, Provides}
import defaults.SystemValues
import org.springframework.mail.MailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

/**
  * @author Romesh Selvan
  */
object MailSenderProducer extends AbstractModule{

  override def configure(): Unit = {}

  @Provides
  def mailSender : MailSender = {
    val javaMailSender = new JavaMailSenderImpl
    javaMailSender.setHost(SystemValues.MAIL_HOST)
    javaMailSender.setPort(SystemValues.MAIL_PORT.toInt)
    javaMailSender.setProtocol(JavaMailSenderImpl.DEFAULT_PROTOCOL)
    javaMailSender.setUsername(SystemValues.MAIL_USERNAME)
    javaMailSender.setPassword(SystemValues.MAIL_PASSWORD)
    val properties = new Properties
    properties.setProperty("mail.smtp.starttls.enable", "true")
    javaMailSender.setJavaMailProperties(properties)
    javaMailSender
  }
}
