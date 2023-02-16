package dev.khusanjon.docmansys.model.entity

import java.time.LocalDateTime

case class FormSubmission(id: Option[Long], date: LocalDateTime, webFormId: Long, submitterId: Option[Long])
