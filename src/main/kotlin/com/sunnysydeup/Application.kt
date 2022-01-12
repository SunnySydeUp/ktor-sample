package com.sunnysydeup

import com.sunnysydeup.di.configureKoin
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.sunnysydeup.plugins.*
import com.sunnysydeup.repositories.configureDatabase

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureDatabase()
        configureKoin()
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
