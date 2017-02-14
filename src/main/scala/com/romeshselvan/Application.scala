package com.romeshselvan

import com.romeshselvan.processors.producer.QueueRunnerProducer


object Application extends App {
  QueueRunnerProducer.apply.runQueue
}