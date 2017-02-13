package processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.Message
import com.google.inject.Inject

/**
  * @author Romesh Selvan
  */
@Inject
class MessageDeleter(a : AmazonSQSAsyncClient) {

  val amazonSQSAsyncClient: AmazonSQSAsyncClient = a

  def deleteMessages(messages: List[Message]) : Unit = {
    messages.foreach(m => {

    })
  }
}
