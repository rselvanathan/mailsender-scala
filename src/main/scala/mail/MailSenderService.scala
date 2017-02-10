package mail

import domain.Email

/**
  * @author Romesh Selvan
  */
trait MailSenderService {
  type T <: Email
  def sendMail(email: T) : Unit
}
