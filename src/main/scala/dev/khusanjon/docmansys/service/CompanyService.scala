package dev.khusanjon.docmansys.service


import dev.khusanjon.docmansys.model.dao.CompanyDao
import dev.khusanjon.docmansys.model.entity.Company
import spray.json.{DefaultJsonProtocol, RootJsonFormat, enrichAny}

import scala.concurrent.ExecutionContext.Implicits.global

trait JsonMapping extends DefaultJsonProtocol {
  implicit val companyFormat: RootJsonFormat[Company] = jsonFormat3(Company)
}

object CompanyService extends JsonMapping {

  def getAll() = CompanyDao.findAll().map(_.toJson)

  def getOne(id: Long) = CompanyDao.findById(id).map(_.toJson)

  def create(company: Company) = CompanyDao.create(company).map(_.toJson)

  def update(id: Long, newCompany: Company) = CompanyDao.update(id, newCompany).map(_.toJson)

  def delete(id: Long) = CompanyDao.delete(id).map(_.toJson)
}
