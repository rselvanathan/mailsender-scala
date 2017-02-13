package processors

import javax.xml.ws.AsyncHandler

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.{DeleteMessageRequest, DeleteMessageResult, Message}
import defaults.SystemValues
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSuite, Matchers}
import org.mockito.Mockito._
import org.mockito.Matchers._

/**
  * @author Romesh Selvan
  */
class MessageDeleterTest extends FunSuite with Matchers with MockitoSugar {

  val amazonSQSClient : AmazonSQSAsyncClient = mock[AmazonSQSAsyncClient]
  val messageDeleter = new MessageDeleter(amazonSQSClient)

  test("When List of messages is empty then do not delete any of the messages") {
    messageDeleter.deleteMessages(List.empty)
    verify(amazonSQSClient, never).deleteMessageAsync(any[DeleteMessageRequest], any)
  }

  test("When List of messages has items then call delete on all of the messages") {
    val receiptIdOne = "receiptIdOne"
    val receiptIdTwo = "receiptIdTwo"
    messageDeleter.deleteMessages(List(getMessage(receiptIdOne), getMessage(receiptIdTwo)))

    val expectedDeleteMessageRequestOne = new DeleteMessageRequest(SystemValues.AWS_SQS_QUEUE_URL, receiptIdOne)
    val expectedDeleteMessageRequestTwo = new DeleteMessageRequest(SystemValues.AWS_SQS_QUEUE_URL, receiptIdTwo)
    verify(amazonSQSClient).deleteMessageAsync(org.mockito.Matchers.eq(expectedDeleteMessageRequestOne), any)
    verify(amazonSQSClient).deleteMessageAsync(org.mockito.Matchers.eq(expectedDeleteMessageRequestTwo), any)
  }

  def getMessage(receiptId : String) : Message = new Message().withReceiptHandle(receiptId)
}
