package com.romeshselvan.processors

import java.util
import java.util.{Collections, Properties}

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{DeleteMessageRequest, Message}
import com.romeshselvan.defaults.SystemValues
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

import scala.io.Source._

/**
  * @author Romesh Selvan
  */
class MessageDeleterTest extends FunSuite with Matchers with MockitoSugar with BeforeAndAfterAll {

  override def beforeAll() {
    val properties = new Properties()
    properties.load(fromURL(getClass.getResource("/test.properties")).bufferedReader())
    properties.entrySet().forEach(entry => sys.props.put(entry.getKey.toString, entry.getValue.toString))
  }

  val amazonSQSClient : AmazonSQSAsyncClient = mock[AmazonSQSAsyncClient]
  val messageDeleter = new MessageDeleter(amazonSQSClient)

  test("When List of messages is empty then do not delete any of the messages") {
    messageDeleter.deleteMessages(List.empty)
    verify(amazonSQSClient, never).deleteMessage(any[DeleteMessageRequest])
  }

  test("When List of messages has items then call delete on all of the messages") {
    val receiptIdOne = "receiptIdOne"
    val receiptIdTwo = "receiptIdTwo"
    messageDeleter.deleteMessages(List(getMessage(receiptIdOne), getMessage(receiptIdTwo)))

    val expectedDeleteMessageRequestOne = new DeleteMessageRequest(SystemValues.AWS_SQS_QUEUE_URL, receiptIdOne)
    val expectedDeleteMessageRequestTwo = new DeleteMessageRequest(SystemValues.AWS_SQS_QUEUE_URL, receiptIdTwo)
    verify(amazonSQSClient).deleteMessage(org.mockito.Matchers.eq(expectedDeleteMessageRequestOne))
    verify(amazonSQSClient).deleteMessage(org.mockito.Matchers.eq(expectedDeleteMessageRequestTwo))
  }

  def getMessage(receiptId : String) : Message = new Message().withReceiptHandle(receiptId)
}
