package producers

import java.util.Properties

import com.google.inject.{AbstractModule, Provides}
import org.springframework.mail.MailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

/**
  * @author Romesh Selvan
  */
object MailSenderProducer extends AbstractModule{

  val host : Option[String] = sys.env.get("MAIL_HOST")
  val port : Option[String] = sys.env.get("MAIL_PORT")
  val username : Option[String] = sys.env.get("MAIL_USERNAME")
  val password : Option[String] = sys.env.get("MAIL_PASSWORD")

  if(host.isEmpty || port.isEmpty || username.isEmpty || password.isEmpty)
    throw new IllegalArgumentException("A Mail property is missing. Application cannot start without it.")

  override def configure(): Unit = {}

  @Provides
  def mailSender : MailSender = {
    val javaMailSender = new JavaMailSenderImpl
    javaMailSender.setHost(host.get)
    javaMailSender.setPort(port.get.toInt)
    javaMailSender.setProtocol(JavaMailSenderImpl.DEFAULT_PROTOCOL)
    javaMailSender.setUsername(username.get)
    javaMailSender.setPassword(password.get)
    val properties = new Properties
    properties.setProperty("mail.smtp.starttls.enable", "true")
    javaMailSender.setJavaMailProperties(properties)
    javaMailSender
  }
}
