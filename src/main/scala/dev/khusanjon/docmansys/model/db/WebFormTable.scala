package dev.khusanjon.docmansys.model.db

import dev.khusanjon.docmansys.model.entity.WebForm
import slick.jdbc.PostgresProfile.api._

class WebFormTable(tag: Tag) extends Table[WebForm](tag, "web_forms") {
  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def title: Rep[String] = column[String]("title")

  def * = (id.?, title) <> ((WebForm.apply _).tupled, WebForm.unapply)
}
