package com.sunnysydeup.users

import io.ktor.routing.*

fun Routing.users(controller: UserController) {
    route("users") {
        get {
            controller.get(this.context)
        }
    }
}