package com.romeshselvan.mailer

/**
  * @author Romesh Selvan
  */
case class MailConfig(host: String, port: Int, username: String, password: String, tlsEnabled: Boolean)
