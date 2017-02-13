package com.romeshselvan.mail

import com.romeshselvan.domain.Email

/**
  * @author Romesh Selvan
  */
trait MailSenderService {
  type T <: Email
  def sendMail(email: T) : Unit
}
