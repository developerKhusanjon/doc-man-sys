package dev.khusanjon.docmansys.model.entity

case class FieldValue(id: Option[Long], inputData: String, formFieldId: Long, formSubmissionId: Long)
