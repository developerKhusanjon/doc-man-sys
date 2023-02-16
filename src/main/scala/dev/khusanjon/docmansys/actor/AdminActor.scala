package dev.khusanjon.docmansys.actor

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object AdminActor {

  trait Command
  case class CreateCompany(name: String, address: String, replyTo: ActorRef[Action]) extends Command
  case class CreateEmployee(name: String, role: String, companyId: Long, replyTo: ActorRef[Action]) extends Command
  case class CreateWebForm(title: String, replyTo: ActorRef[Action]) extends Command
  case class EditWebForm(title: String, replyTo: ActorRef[Action]) extends Command

  trait Action
  case class CompanyCreated() extends Action
  case class EmployeeCreated() extends Action
  case class WebFormCreated() extends Action
  case class WebFormUpdated() extends Action

  case class NotPermitted() extends Action
  case class Failed(reason: String) extends Action

  def apply(): Behavior[Command] = Behaviors.receiveMessage {
    case CreateCompany(name, address, replyTo) =>
      // impl
      Behaviors.same
    case CreateEmployee(name, role, companyId, replyTo) =>
      // impl
      Behaviors.same
    case CreateWebForm(title, replyTo) =>
      // impl
      Behaviors.same
    case EditWebForm(title, replyTo) =>
      // impl
      Behaviors.same
  }

}
