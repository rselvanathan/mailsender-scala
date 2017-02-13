package processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{DeleteMessageRequest, Message}
import com.google.inject.Inject
import defaults.SystemValues

/**
  * @author Romesh Selvan
  */
@Inject
class MessageDeleter(a : AmazonSQSAsyncClient) {

  val amazonSQSAsyncClient: AmazonSQSAsyncClient = a

  def deleteMessages(messages: List[Message]) : Unit = {
    messages.foreach(m => {
      val request = new DeleteMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withReceiptHandle(m.getReceiptHandle)
      amazonSQSAsyncClient.deleteMessage(request)
    })
  }
}
