package mail
import com.google.inject.Inject
import domain.RomCharmEmail
import org.springframework.mail.{MailSender, SimpleMailMessage}


/**
  * @author Romesh Selvan
  */
@Inject
class RomCharmMailService(mc : MailSender) extends MailSenderService {
  type T = RomCharmEmail

  val mailSender : MailSender = mc

  override def sendMail(email: T): Unit = {
    val mailMessage = new SimpleMailMessage()
    mailMessage.setFrom("romeshselvan@hotmail.co.uk")
    mailMessage.setTo(email.email)
    mailMessage.setSubject("RSVP Confirmation - Romesh & Charmikha")
    mailMessage.setText(generateTemplateMessage(email))
    mailSender.send(mailMessage)
  }

  private def generateTemplateMessage(email : T) : String = {
    val builder = new StringBuilder
    builder.append("Hey ").append(email.firstName).append("\n")
    builder.append("\n")
    builder.append("Thank you for letting us know whether you are coming to the reception.").append("\n")
    builder.append("\n")
    builder.append("Attending : ").append(getAttendanceString(email.areAttending)).append("\n")
    builder.append("Number of people Attending : ").append(email.numberAttending).append("\n")
    builder.append("\n")
    builder.append("If you would like to make any changes, please contact us as soon as possible.").append("\n")
    builder.append("\n")
    builder.append("Kind Regards,").append("\n")
    builder.append("\n")
    builder.append("Romesh & Charmikha")
    builder.toString()
  }

  private def getAttendanceString(b : Boolean) : String = if(b) "Yes" else "No"
}
