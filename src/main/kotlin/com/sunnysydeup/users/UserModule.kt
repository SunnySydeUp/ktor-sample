package com.sunnysydeup.users

import org.koin.dsl.module

val userModule = module {
    single { UserController() }
}