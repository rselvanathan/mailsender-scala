package com.romeshselvan.producers

import java.util.concurrent.{Executors, ScheduledExecutorService}

/**
  * @author Romesh Selvan
  */
object ExecutorServiceProducer {

   val scheduledExecutorService : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
}
