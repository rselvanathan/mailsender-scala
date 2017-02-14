package com.romeshselvan.processors

import com.amazonaws.services.sqs.model.Message
import com.romeshselvan.defaults.AppType
import com.romeshselvan.domain.producer.EmailMessageProducer
import com.romeshselvan.mail.MailSenderService
import com.romeshselvan.mail.producer.MailSenderServiceProducer
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._

/**
  * @author Romesh Selvan
  */
class MessageProcessor(m : MailSenderServiceProducer) {

  implicit val formats = DefaultFormats
  val mailSenderServiceProducer: MailSenderServiceProducer = m

  def processMessages(messages : Seq[Message]): Unit = {
    messages.foreach(sendMail)
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
