package mail

import domain.RomCharmEmail
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSuite, Matchers}
import org.springframework.mail.{MailSender, SimpleMailMessage}

/**
  * @author Romesh Selvan
  */
class RomCharmMailServiceTest extends FunSuite with Matchers with MockFactory{

  val EMAIL : String = "romesh@hotmail.com"
  val FIRSTNAME : String = "romesh"
  val LASTNAME : String = "selvan"
  val AREATTENDING : Boolean = true
  val NUMBERATTENDING : Int = 2

  val mailSender : MailSender = stub[MailSender]
  val mailSenderService : MailSenderService = new RomCharmMailService(mailSender)

  test("Expect the default template message to be sent when passing in a RomCharmEmail object") {
    val email = getDefaultEmail
    val expectedSimpleMessage = getDefaultSimpleMessage
    mailSenderService.sendMail(email.asInstanceOf[mailSenderService.T])
    (mailSender.send _).verify(expectedSimpleMessage)
  }

  private def getDefaultEmail = RomCharmEmail(EMAIL, FIRSTNAME, LASTNAME, AREATTENDING, NUMBERATTENDING)

  private def getDefaultSimpleMessage : SimpleMailMessage = {
    val mailMessage = new SimpleMailMessage()
    mailMessage.setFrom("romeshselvan@hotmail.co.uk")
    mailMessage.setTo(EMAIL)
    mailMessage.setSubject("RSVP Confirmation - Romesh & Charmikha")
    mailMessage.setText(generateDefaultTemplateMessage)
    mailMessage
  }

  private def generateDefaultTemplateMessage : String = {
    val builder = new StringBuilder
    builder.append(s"Hey $FIRSTNAME\n")
    builder.append("\n")
    builder.append("Thank you for letting us know whether you are coming to the reception.").append("\n")
    builder.append("\n")
    builder.append("Attending : Yes\n")
    builder.append(s"Number of people Attending : $NUMBERATTENDING\n")
    builder.append("\n")
    builder.append("If you would like to make any changes, please contact us as soon as possible.").append("\n")
    builder.append("\n")
    builder.append("Kind Regards,").append("\n")
    builder.append("\n")
    builder.append("Romesh & Charmikha")
    builder.toString()
  }
}
