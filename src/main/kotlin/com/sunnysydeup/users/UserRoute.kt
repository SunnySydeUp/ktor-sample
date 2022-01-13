package com.sunnysydeup.users

import com.sunnysydeup.plugins.isPublic
import io.ktor.application.*
import io.ktor.routing.*

fun Routing.users(controller: UserController) {
    route("users") {
        get {
            if (call.isPublic()) {
                controller.get(this.context)
            }
        }
    }
}