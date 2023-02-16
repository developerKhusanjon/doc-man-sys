package dev.khusanjon.docmansys.model.entity

case class FormField(id: Option[Long], title: String, isRequired: Boolean, webFormId: Long)
