package com.sunnysydeup.repositories

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Users : LongIdTable() {
    val username = varchar("username", 100).uniqueIndex()
}

class User(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<User>(Users)

    var username by Users.username
}

class UserRepository {
    init {
        transaction {
            SchemaUtils.create(Users)
        }
    }

    suspend fun findAllUsers(): List<User> {
        return transaction {
            User.all().toList()
        }
    }
}