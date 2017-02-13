package processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{Message, ReceiveMessageRequest}
import defaults.SystemValues
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Romesh Selvan
  */
@Component
@Autowired
class QueueProcessor(a : AmazonSQSAsyncClient, m : MessageProcessor, d : MessageDeleter) extends Runnable{

  val amazonSQSAsyncClient : AmazonSQSAsyncClient = a
  val messageProcessor : MessageProcessor = m
  val messageDeleter : MessageDeleter = d

  override def run(): Unit = {
    val request = new ReceiveMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withMaxNumberOfMessages(3)
    val messages : java.util.List[Message] = amazonSQSAsyncClient.receiveMessage(request).getMessages
    if(messages.isEmpty)
      return
    messageProcessor.processMessages(messages)
    messageDeleter.deleteMessages(messages)
  }
}
