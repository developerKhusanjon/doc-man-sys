package dev.khusanjon.docmansys.migration

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.output.MigrateResult

trait MigrationConfig {

  private val flyway = new Flyway(Flyway.configure())

  def migrate(): MigrateResult = flyway.migrate()

  def reloadSchema(): MigrateResult = {
    flyway.clean()
    flyway.migrate()
  }
}
