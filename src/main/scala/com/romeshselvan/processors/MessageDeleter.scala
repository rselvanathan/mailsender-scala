package com.romeshselvan.processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{DeleteMessageRequest, Message}
import com.romeshselvan.defaults.SystemValues
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Romesh Selvan
  */
@Component
@Autowired
class MessageDeleter(a : AmazonSQSAsyncClient) {

  val amazonSQSAsyncClient: AmazonSQSAsyncClient = a

  def deleteMessages(messages: java.util.List[Message]) : Unit = {
    messages.forEach(m => {
      val request = new DeleteMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withReceiptHandle(m.getReceiptHandle)
      amazonSQSAsyncClient.deleteMessage(request)
    })
  }
}
