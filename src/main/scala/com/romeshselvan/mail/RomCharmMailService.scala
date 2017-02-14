package com.romeshselvan.mail

import com.romeshselvan.domain.RomCharmEmail
import com.romeshselvan.mailer.{MailMessage, Mailer}
import com.typesafe.scalalogging.Logger


/**
  * @author Romesh Selvan
  */
class RomCharmMailService(mailSender : Mailer) extends MailSenderService {
  type T = RomCharmEmail

  val logger = Logger("RomCharmMailService")

  override def sendMail(email: T): Unit = {
    logger.info(s"Sending Mail with details ${email.toString}")
    val mailMessage = MailMessage("romeshselvan@hotmail.co.uk", email.email, "RSVP Confirmation - Romesh & Charmikha", generateTemplateMessage(email))
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
