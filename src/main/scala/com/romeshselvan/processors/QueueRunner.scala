package com.romeshselvan.processors

import java.util.concurrent.{ScheduledExecutorService, TimeUnit}

import com.romeshselvan.defaults.SystemValues

/**
  * @author Romesh Selvan
  */
class QueueRunner(queueProcessor: QueueProcessor, scheduledExecutorService : ScheduledExecutorService) {

  def runQueue = scheduledExecutorService.scheduleWithFixedDelay(queueProcessor, 1, SystemValues.MESSAGE_RETRIEVE_DELAY.toLong, TimeUnit.SECONDS)
}
