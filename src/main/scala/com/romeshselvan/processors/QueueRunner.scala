package com.romeshselvan.processors

import java.util.concurrent.{ScheduledExecutorService, TimeUnit}

import com.romeshselvan.defaults.SystemValues

/**
  * @author Romesh Selvan
  */
class QueueRunner(q: QueueProcessor, s : ScheduledExecutorService) {

  val queueProcessor : QueueProcessor = q
  val scheduledExecutorService : ScheduledExecutorService = s

  def runQueue() : Unit = scheduledExecutorService.scheduleWithFixedDelay(queueProcessor, 1, SystemValues.MESSAGE_RETRIEVE_DELAY.toLong, TimeUnit.SECONDS)
}
