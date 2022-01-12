package com.sunnysydeup.repositories

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
}