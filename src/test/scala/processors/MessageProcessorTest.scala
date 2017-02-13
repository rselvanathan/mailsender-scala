package processors

import com.amazonaws.services.sqs.model.Message
import defaults.AppType
import domain.RomCharmEmail
import mail.MailSenderService
import mail.producer.MailSenderServiceProducer
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

/**
  * @author Romesh Selvan
  */
class MessageProcessorTest extends FunSuite  with Matchers with MockFactory {

  val EMAIL : String = "romesh@hotmail.com"
  val FIRSTNAME : String = "romesh"
  val LASTNAME : String = "selvan"
  val AREATTENDING : Boolean = true
  val NUMBERATTENDING : Int = 2

  val mailSenderService : MailSenderService = stub[MailSenderService]
  val mailSenderServiceProducer : MailSenderServiceProducer = stub[MailSenderServiceProducer]
  val messageProcesser : MessageProcessor = new MessageProcessor(mailSenderServiceProducer)

  test("When processing messages and there is nothing to process, then do nothing") {
    before
    messageProcesser.processMessages(List.empty)
    (mailSenderService.sendMail _).verify(*).never()
  }

  test("When Message List contains a message with AppType ROMCHARM, then sendMail With The Correct RomCharmEmail should be sent") {
    before
    val message : Message = new Message().withBody(getDefaultSQSJsonBody("ROMCHARM"))
    val expectedEmail : RomCharmEmail = getDefaultEmail
    messageProcesser.processMessages( List (message))
    (mailSenderService.sendMail _).verify(expectedEmail.asInstanceOf[mailSenderService.T])
  }

  private def getDefaultSQSJsonBody(appType : String) : String =
    s"""{"Message":"{\\\"email\\\":\\\"$EMAIL\\\",\\\"firstName\\\":\\\"$FIRSTNAME\\\",\\\"lastName\\\":\\\"$LASTNAME\\\",\\\"areAttending\\\":$AREATTENDING,\\\"numberAttending\\\":$NUMBERATTENDING}","MessageAttributes":{"apptype":{"Type":"String","Value":"$appType"}}}"""

  private def getDefaultEmail : RomCharmEmail = RomCharmEmail(EMAIL, FIRSTNAME, LASTNAME, AREATTENDING, NUMBERATTENDING)

  private def before = {
    (mailSenderServiceProducer.apply _).when(AppType.ROMCHARM).returning(mailSenderService)
  }
}
