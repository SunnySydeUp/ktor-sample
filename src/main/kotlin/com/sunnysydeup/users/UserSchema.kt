package com.sunnysydeup.users

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.sunnysydeup.plugins.GraphUser
import com.sunnysydeup.repositories.User
import com.sunnysydeup.repositories.UserRepository
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.random.Random

fun SchemaBuilder.users(userRepository: UserRepository) = query("users") {
    resolver { ->
        transaction {
            User.new { username = "abc" + Random.nextInt(10) }
        }
        val users = userRepository.findAllUsers()
        val user = users.first()
        GraphUser(user.username)
    }
}