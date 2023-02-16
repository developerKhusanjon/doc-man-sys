package dev.khusanjon.docmansys.model.dto

import java.time.LocalDateTime

case class FormSubmissionDto(id: Long, date: LocalDateTime, webFormId: Long, fields: List[Map[String, String]])
