package com.romeshselvan.defaults

import enumeratum._

import scala.collection.immutable.IndexedSeq

/**
  * @author Romesh Selvan
  */
sealed trait AppType extends EnumEntry

object AppType extends Enum[AppType] {

  // Enum Definitions

  case object ROMCHARM extends AppType

  override def values: IndexedSeq[AppType] = findValues
}
