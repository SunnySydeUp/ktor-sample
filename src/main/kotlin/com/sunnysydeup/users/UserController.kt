package com.sunnysydeup.users

import com.sunnysydeup.repositories.User
import com.sunnysydeup.repositories.UserRepository
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.random.Random

class UserController(
    private val userRepository: UserRepository,
) {
    suspend fun get(context: ApplicationCall) {
        transaction {
            User.new { username = "abc" + Random.nextInt(10) }
        }
        val users = userRepository.findAllUsers()
        context.respond(users.map { it.username }.map { "username" to it })
    }
}