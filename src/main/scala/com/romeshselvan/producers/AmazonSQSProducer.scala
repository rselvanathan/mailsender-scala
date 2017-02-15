package com.romeshselvan.producers

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.{Region, Regions}
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.romeshselvan.defaults.SystemValues

/**
  * @author Romesh Selvan
  */
object AmazonSQSProducer {

  val amazonSQSClient: AmazonSQSAsyncClient = new AmazonSQSAsyncClient(new BasicAWSCredentials(SystemValues.AWS_ACCESS_KEY, SystemValues.AWS_SECRET_KEY)).withRegion(Region.getRegion(Regions.EU_WEST_1))
}
