package com.romeshselvan.producers

import java.util.concurrent.{Executors, ScheduledExecutorService}

import org.springframework.context.annotation.{Bean, Configuration}

/**
  * @author Romesh Selvan
  */
@Configuration
class ExecutorServiceProducer {

  @Bean
  def scheduledExecutor : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
}
