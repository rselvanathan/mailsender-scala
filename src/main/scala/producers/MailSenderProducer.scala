package producers

import java.util.Properties

import defaults.SystemValues
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.mail.MailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

/**
  * @author Romesh Selvan
  */
@Configuration
object MailSenderProducer {

  @Bean
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
