package com.sunnysydeup.users

import io.ktor.application.*
import io.ktor.response.*

class UserController {
    suspend fun get(context: ApplicationCall) {
        context.respondText("User")
    }
}