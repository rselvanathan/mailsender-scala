package processors

import java.util.concurrent.{ScheduledExecutorService, TimeUnit}

import defaults.SystemValues
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author Romesh Selvan
  */
@Component
@Autowired
class QueueRunner(q: QueueProcessor, s : ScheduledExecutorService) {

  val queueProcessor : QueueProcessor = q
  val scheduledExecutorService : ScheduledExecutorService = s

  def runQueue() : Unit = scheduledExecutorService.scheduleWithFixedDelay(queueProcessor, 1, SystemValues.MESSAGE_RETRIEVE_DELAY.toLong, TimeUnit.SECONDS)
}
