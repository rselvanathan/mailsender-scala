package producers

import java.util.concurrent.{Executors, ScheduledExecutorService}

import com.google.inject.{AbstractModule, Provides}

/**
  * @author Romesh Selvan
  */
object ExecutorServiceProducer extends AbstractModule{

  override def configure(): Unit = {}

  @Provides
  def scheduledExecutor : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
}
