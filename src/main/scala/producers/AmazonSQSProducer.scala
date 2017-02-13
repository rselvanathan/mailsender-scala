package producers

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.{Region, Regions}
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.google.inject.{AbstractModule, Provides}

/**
  * @author Romesh Selvan
  */
object AmazonSQSProducer extends AbstractModule{

  val accessKey : Option[String] = sys.env.get("AWS_ACCESS_KEY_ID")
  val secretKey : Option[String] = sys.env.get("AWS_SECRET_ACCESS_KEY")

  override def configure(): Unit = {}

  @Provides
  def amazonSQSClient : AmazonSQSAsyncClient = {
    val client : AmazonSQSAsyncClient = new AmazonSQSAsyncClient(new BasicAWSCredentials(accessKey.get, secretKey.get))
    client.setRegion(Region.getRegion(Regions.EU_WEST_1))
    client
  }
}
