package com.romeshselvan.processors

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{Message, ReceiveMessageRequest}
import com.romeshselvan.defaults.SystemValues
import scala.collection.JavaConverters._

/**
  * @author Romesh Selvan
  */
class QueueProcessor(a : AmazonSQSAsyncClient, m : MessageProcessor, d : MessageDeleter) extends Runnable{

  val amazonSQSAsyncClient : AmazonSQSAsyncClient = a
  val messageProcessor : MessageProcessor = m
  val messageDeleter : MessageDeleter = d

  override def run(): Unit = {
    val request = new ReceiveMessageRequest().withQueueUrl(SystemValues.AWS_SQS_QUEUE_URL).withMaxNumberOfMessages(3)
    val messages : Seq[Message] = amazonSQSAsyncClient.receiveMessage(request).getMessages.asScala
    if(messages.isEmpty)
      return
    messageProcessor.processMessages(messages)
    messageDeleter.deleteMessages(messages)
  }
}
