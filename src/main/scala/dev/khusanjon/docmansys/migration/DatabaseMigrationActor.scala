package dev.khusanjon.docmansys.migration

import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}

object DatabaseMigrationActor {
  sealed trait Command
  case object Migrate extends Command
  case class MigrationResult(success: Boolean) extends Command

  def apply(notificationActor: ActorRef[MigrationResult]): Behavior[Command] =
    Behaviors.setup(context => new DatabaseMigrationActor(context, notificationActor))
}

class DatabaseMigrationActor(context: ActorContext[DatabaseMigrationActor.Command],
                             notificationActor: ActorRef[DatabaseMigrationActor.MigrationResult])
  extends AbstractBehavior[DatabaseMigrationActor.Command](context) with MigrationConfig {

  import DatabaseMigrationActor._

  override def onMessage(msg: Command): Behavior[Command] = msg match {
    case Migrate =>
      context.log.info("Starting database migrations")
      try {
        val migrationResult: Unit = migrate()
        notificationActor ! MigrationResult(success = true)
      } catch {
        case ex: Exception =>
          context.log.error("Error during database migrations", ex)
          notificationActor ! MigrationResult(success = false)
      }
      Behaviors.stopped
  }
}