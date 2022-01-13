package com.sunnysydeup

import com.sunnysydeup.di.configureKoin
import com.sunnysydeup.plugins.configureHTTP
import com.sunnysydeup.plugins.configureMonitoring
import com.sunnysydeup.plugins.configureRouting
import com.sunnysydeup.plugins.configureSerialization
import com.sunnysydeup.repositories.configureDatabase
import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main() {
    embeddedServer(CIO, env()).start(wait = true)
}

fun env() = applicationEngineEnvironment {
    module {
        configureDatabase()
        configureKoin()
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }
    // Private API
    connector {
        host = "127.0.0.1"
        port = 8081
    }
    // Public API
    connector {
        host = "0.0.0.0"
        port = 8080
    }
}