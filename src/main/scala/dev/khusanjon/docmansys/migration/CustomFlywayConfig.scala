package dev.khusanjon.docmansys.migration

import com.typesafe.config.Config
import org.flywaydb.core.api.configuration.FluentConfiguration

class CustomFlywayConfig(config: Config) extends FluentConfiguration {
  def this() = this(config)

  private val flywayConfig = {
    val url = config.getString("database.url")
    val user = config.getString("database.user")
    val password = config.getString("database.password")

    dataSource(url, user, password)
  }

  if (config.getBoolean("flyway.validateOnMigrate")) {
    flywayConfig.validateOnMigrate(true)
  }

  if (config.getBoolean("flyway.outOfOrder")) {
    flywayConfig.outOfOrder(true)
  }

  if (config.hasPath("flyway.locations")) {
    val locations = config.getStringList("flyway.locations").toArray(Array[String]())
    flywayConfig.locations(config.getString("flyway.locations"))
  }

  if (config.hasPath("flyway.encoding")) {
    val encoding = config.getString("flyway.encoding")
    flywayConfig.encoding(encoding)
  }
}
