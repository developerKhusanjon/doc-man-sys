package dev.khusanjon.docmansys.actor

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object Starter {

  trait Command

  def apply(): Behavior[AdminActor.Action with EmployeeActor.Action] = Behaviors.receiveMessage {

  }

}
