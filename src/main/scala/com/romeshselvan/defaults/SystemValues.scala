package com.romeshselvan.defaults

/**
  * @author Romesh Selvan
  */
object SystemValues {
  val AWS_ACCESS_KEY : String = sys.props.getOrElse("AWS_ACCESS_KEY_ID", sys.env.getOrElse("AWS_ACCESS_KEY_ID", throw new NullPointerException("AWS_ACCESS_KEY not defined")))
  val AWS_SECRET_KEY: String = sys.props.getOrElse("AWS_SECRET_ACCESS_KEY", sys.env.getOrElse("AWS_SECRET_ACCESS_KEY", throw new NullPointerException("AWS_SECRET_ACCESS_KEY not defined")))
  val AWS_SQS_QUEUE_URL: String = sys.props.getOrElse("AWS_SQS_QUEUE_URL", sys.env.getOrElse("AWS_SQS_QUEUE_URL", throw new NullPointerException("AWS_SQS_QUEUE_URL not defined")))
  val MAIL_HOST: String = sys.props.getOrElse("MAIL_HOST", sys.env.getOrElse("MAIL_HOST", throw new NullPointerException("MAIL_HOST not defined")))
  val MAIL_PORT: String = sys.props.getOrElse("MAIL_PORT", sys.env.getOrElse("MAIL_PORT", throw new NullPointerException("MAIL_PORT not defined")))
  val MAIL_USERNAME: String = sys.props.getOrElse("MAIL_USERNAME", sys.env.getOrElse("MAIL_USERNAME", throw new NullPointerException("MAIL_USERNAME not defined")))
  val MAIL_PASSWORD: String = sys.props.getOrElse("MAIL_PASSWORD", sys.env.getOrElse("MAIL_PASSWORD", throw new NullPointerException("MAIL_PASSWORD not defined")))
  val MESSAGE_RETRIEVE_DELAY: String = sys.props.getOrElse("MESSAGE_RETRIEVE_DELAY", sys.env.getOrElse("MESSAGE_RETRIEVE_DELAY", throw new NullPointerException("MESSAGE_RETRIEVE_DELAY not defined")))
}
