package com.romeshselvan

import com.romeshselvan.processors.producer.QueueRunnerProducer


object Application extends App {
  private val queueRunner = QueueRunnerProducer.apply
  queueRunner.runQueue()
}