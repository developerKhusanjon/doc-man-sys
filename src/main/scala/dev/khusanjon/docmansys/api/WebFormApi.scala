package dev.khusanjon.docmansys.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import dev.khusanjon.docmansys.model.entity.WebForm
import dev.khusanjon.docmansys.service.WebFormService
import dev.khusanjon.docmansys.service.WebFormService.webFormFormat

object WebFormApi {
  val route: Route =
    (path("web-forms") & get) {
      complete(WebFormService.getAll())
    } ~
      (path("web-forms" / IntNumber) & get) { id =>
        complete(WebFormService.getOne(id))
      } ~
      (path("web-forms") & post) {
        entity(as[WebForm]) { webForm =>
          complete(WebFormService.create(webForm))
        }
      } ~
      (path("web-forms" / IntNumber) & put) { id =>
        entity(as[WebForm]) { webForm =>
          complete(WebFormService.update(id, webForm))
        }
      } ~
      (path("web-forms" / IntNumber) & delete) { id =>
        complete(WebFormService.delete(id))
      }
}
