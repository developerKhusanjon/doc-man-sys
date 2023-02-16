package dev.khusanjon.docmansys.actor

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import dev.khusanjon.docmansys.model.dto.{FormSubmissionDto, WebFormDto}

import java.time.LocalDateTime

object EmployeeActor {

  trait Command
  case class SubmitWebForm(webFormId: Long, formDate: Map[Long, String] = Map.empty, replyTo: ActorRef[Action]) extends Command
  case class ViewWebForm(webFormId: Long, employeeId: Option[Long], replyTo: ActorRef[Action]) extends Command
  case class ViewMySubmissions(employeeId: Long, startDate: Option[LocalDateTime], endDate: Option[LocalDateTime], replyTo: ActorRef[Action]) extends Command

  trait Action
  case class WebFormSubmitted() extends Action
  case class WebFormQueried(webForm: WebFormDto, formData: FormSubmissionDto) extends Action
  case class WebFormsQueried(webForms: List[(WebFormDto, FormSubmissionDto)]) extends Action

  case class NotPermitted() extends Action
  case class Failed(reason: String) extends Action

 def apply(): Behavior[Command] = Behaviors.receiveMessage {
   case SubmitWebForm(webFormId, formDate, replyTo) =>
     // impl
     Behaviors.same
   case ViewWebForm(webFormId, employeeId, replyTo) =>
     // impl
     Behaviors.same
   case ViewMySubmissions(employeeId, startDate, endDate, replyTo) =>
     // impl
     Behaviors.same
 }

}
