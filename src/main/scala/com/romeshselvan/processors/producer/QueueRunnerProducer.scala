package com.romeshselvan.processors.producer

import com.romeshselvan.mail.producer.MailSenderServiceProducer
import com.romeshselvan.processors.{MessageDeleter, MessageProcessor, QueueProcessor, QueueRunner}
import com.romeshselvan.producers.{AmazonSQSProducer, ExecutorServiceProducer}

/**
  * @author Romesh Selvan
  */
object QueueRunnerProducer {
  def apply : QueueRunner  = {
    val messageProcessor = new MessageProcessor(MailSenderServiceProducer)
    val messageDeleter = new MessageDeleter(AmazonSQSProducer.amazonSQSClient)
    val queueProcessor = new QueueProcessor(AmazonSQSProducer.amazonSQSClient, messageProcessor, messageDeleter)
    new QueueRunner(queueProcessor, ExecutorServiceProducer.scheduledExecutorService)
  }
}
