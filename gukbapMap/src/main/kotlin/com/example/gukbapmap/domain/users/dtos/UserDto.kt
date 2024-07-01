package com.example.gukbapmap.domain.users.dtos

import com.example.gukbapmap.domain.users.User

data class UserDto(
    val id: Long?,
    val username: String,
    val token: String? = null,
) {
    companion object {
        fun from(user: User, token: String?): UserDto {
            return UserDto(
                id = user.id,
                username = user.username,
                token = token,
            )
        }

        fun from(user: User): UserDto {
            return UserDto(
                id = user.id,
                username = user.username,
            )
        }
    }
}
