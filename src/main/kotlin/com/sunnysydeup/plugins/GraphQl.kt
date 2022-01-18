package com.sunnysydeup.plugins

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.sunnysydeup.repositories.User
import com.sunnysydeup.repositories.UserRepository
import com.sunnysydeup.users.users
import io.ktor.application.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject
import kotlin.random.Random

fun Application.graphQl() {
    val userRepository: UserRepository by inject()

    install(GraphQL) {
        playground = true
        coroutineDispatcher = Dispatchers.Default
        useDefaultPrettyPrinter = true

        schema {
            users(userRepository)
            type<GraphUser>()
        }
    }
}

data class GraphUser(val username: String)