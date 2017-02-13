package producers

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.{Region, Regions}
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import defaults.SystemValues
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * @author Romesh Selvan
  */
@Configuration
object AmazonSQSProducer {

  @Bean
  def amazonSQSClient : AmazonSQSAsyncClient = {
    val client : AmazonSQSAsyncClient =
      new AmazonSQSAsyncClient(new BasicAWSCredentials(SystemValues.AWS_ACCESS_KEY, SystemValues.AWS_SECRET_KEY))
    client.setRegion(Region.getRegion(Regions.EU_WEST_1))
    client
  }
}
