package producers

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.{Region, Regions}
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.google.inject.{AbstractModule, Provides}
import defaults.SystemValues

/**
  * @author Romesh Selvan
  */
object AmazonSQSProducer extends AbstractModule{

  override def configure(): Unit = {}

  @Provides
  def amazonSQSClient : AmazonSQSAsyncClient = {
    val client : AmazonSQSAsyncClient =
      new AmazonSQSAsyncClient(new BasicAWSCredentials(SystemValues.AWS_ACCESS_KEY, SystemValues.AWS_SECRET_KEY))
    client.setRegion(Region.getRegion(Regions.EU_WEST_1))
    client
  }
}
