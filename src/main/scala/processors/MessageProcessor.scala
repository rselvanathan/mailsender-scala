package processors

import com.amazonaws.services.sqs.model.Message
import defaults.AppType
import domain.producer.EmailMessageProducer
import mail.MailSenderService
import mail.producer.MailSenderServiceProducer
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Romesh Selvan
  */
@Component
@Autowired
class MessageProcessor(m : MailSenderServiceProducer) {

  implicit val formats = DefaultFormats
  val mailSenderServiceProducer: MailSenderServiceProducer = m

  def processMessages(messages : java.util.List[Message]): Unit = {
    messages.forEach(sendMail)
  }

  private def sendMail(message : Message) : Unit = {
    val bodyJValue : JValue = parse(message.getBody)
    val appType = getAppType(bodyJValue \ "MessageAttributes")
    val senderService : MailSenderService = mailSenderServiceProducer(appType)
    senderService.sendMail(EmailMessageProducer(appType, bodyJValue \ "Message").asInstanceOf[senderService.T])
  }

  private def getAppType(messageAttrJson: JValue) : AppType = {
    val messageAttrs : Map[String, Map[String, String]] = messageAttrJson.extract[Map[String, Map[String, String]]]
    val appTypeString : String = messageAttrs("apptype")("Value")
    AppType.withName(appTypeString)
  }
}
