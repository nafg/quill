package io.getquill

import cats.effect._
import com.github.mauricio.async.db.Configuration
import com.github.mauricio.async.db.postgresql.PostgreSQLConnection
import com.github.mauricio.async.db.postgresql.util.URLParser
import com.typesafe.config.Config
import io.getquill.async.effect.AsyncContextConfig
import scala.language.higherKinds

case class PostgresAsyncEffectContextConfig[F[_]: Async](config: Config, factory: Configuration => PostgreSQLConnection = { c => new PostgreSQLConnection(c) })
  extends AsyncContextConfig[F, PostgreSQLConnection](config, factory, URLParser)