package com.sunnysydeup.plugins

import com.sunnysydeup.users.UserController
import com.sunnysydeup.users.users
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    install(AutoHeadResponse)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        val userController: UserController by inject()
        users(userController)

        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationException> { cause ->
                call.respond(HttpStatusCode.Forbidden)
            }
            status(HttpStatusCode.NotFound) {
                call.respondText("404")
            }
        }
    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
