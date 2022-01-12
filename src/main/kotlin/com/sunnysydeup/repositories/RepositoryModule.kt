package com.sunnysydeup.repositories

import org.koin.dsl.module

val repositoryModule = module {
    single { UserRepository() }
}