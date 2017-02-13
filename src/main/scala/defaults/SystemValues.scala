package defaults

/**
  * @author Romesh Selvan
  */
object SystemValues {
  val AWS_ACCESS_KEY = sys.env.getOrElse("AWS_ACCESS_KEY_ID", "TEST_USER")
  val AWS_SECRET_KEY = sys.env.getOrElse("AWS_SECRET_ACCESS_KEY", "TEST_SECRET")
  val AWS_SQS_QUEUE_URL = sys.env.getOrElse("AWS_SQS_QUEUE_URL", "TEST_QUEUE_URL")
  val MAIL_HOST = sys.env.getOrElse("MAIL_HOST", "TEST_MAIL_HOST")
  val MAIL_PORT = sys.env.getOrElse("MAIL_PORT", "TEST_MAIL_PORT")
  val MAIL_USERNAME = sys.env.getOrElse("MAIL_USERNAME", "TEST_MAIL_USERNAME")
  val MAIL_PASSWORD = sys.env.getOrElse("MAIL_USERNAME", "TEST_MAIL_PASSWORD")
}
