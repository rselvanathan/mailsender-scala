package com.romeshselvan.processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{Message, ReceiveMessageRequest}
import com.romeshselvan.defaults.SystemValues
import com.typesafe.scalalogging.Logger

import scala.collection.JavaConverters._

/**
  * @author Romesh Selvan
  */
class QueueProcessor(amazonSQSAsyncClient: AmazonSQSAsyncClient, messageProcessor: MessageProcessor, messageDeleter : MessageDeleter) extends Runnable{

  val logger = Logger("QueueProcessor")

  override def run = {
    val request = new ReceiveMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withMaxNumberOfMessages(3)
    val messages : Seq[Message] = amazonSQSAsyncClient.receiveMessage(request).getMessages.asScala
    if(messages.nonEmpty) {
      logger.info(s"Number of message retrieved : ${messages.size}")
      messageProcessor.processMessages(messages)
      messageDeleter.deleteMessages(messages)
    }
  }
}
