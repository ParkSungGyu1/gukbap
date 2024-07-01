package com.example.gukbapmap.domain.users

import com.example.gukbapmap.domain.users.dtos.CreateUserArguments
import com.example.gukbapmap.domain.users.dtos.SignInArguments
import com.example.gukbapmap.domain.users.dtos.UserDto


interface UserService {
    fun createUser(createUserArguments: CreateUserArguments): UserDto
    fun signIn(signInArguments: SignInArguments): UserDto
}
