package com.example.gukbapmap.securities

import com.example.gukbapmap.domain.users.User


data class UserPrincipal(
    val id: Long,
    val username: String,
) {
    fun to(): User {
        return User(
            id = id,
            username = username,
            password = "",
        )
    }
}
