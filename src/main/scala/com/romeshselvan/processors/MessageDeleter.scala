package com.romeshselvan.processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{DeleteMessageRequest, Message}
import com.romeshselvan.defaults.SystemValues
import com.typesafe.scalalogging.Logger

/**
  * @author Romesh Selvan
  */
class MessageDeleter(amazonSQSAsyncClient : AmazonSQSAsyncClient) {

  val logger = Logger("MessageDeleter")

  def deleteMessages(messages: Seq[Message]) = {
    logger.info("Deleting Message from Queue.")
    messages.foreach(m => {
      val request = new DeleteMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withReceiptHandle(m.getReceiptHandle)
      amazonSQSAsyncClient.deleteMessage(request)
    })
  }
}
