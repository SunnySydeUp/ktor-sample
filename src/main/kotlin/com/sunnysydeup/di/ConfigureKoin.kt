package com.sunnysydeup.di

import com.sunnysydeup.repositories.repositoryModule
import com.sunnysydeup.users.userModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(userModule, repositoryModule)
    }
}