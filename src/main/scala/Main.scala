import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Main extends App {
  private implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "main-system")
  protected implicit val executor: ExecutionContext = system.executionContext

  val route =
    path("health") {
      get {
        complete(StatusCodes.OK)
      }
    }

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)

  println(s"Server now online. Please navigate to http://localhost:8080/health\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}