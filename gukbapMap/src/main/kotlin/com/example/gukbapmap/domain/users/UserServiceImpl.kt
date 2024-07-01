package com.example.gukbapmap.domain.users

import com.example.gukbapmap.securities.JwtPlugin
import com.example.gukbapmap.domain.users.User
import com.example.gukbapmap.domain.users.UserRepository
import com.example.gukbapmap.domain.users.dtos.CreateUserArguments
import com.example.gukbapmap.domain.users.dtos.SignInArguments
import com.example.gukbapmap.domain.users.dtos.UserDto
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin,
) : UserService {
    override fun createUser(createUserArguments: CreateUserArguments): UserDto {
        val user = User(
            username = createUserArguments.username,
            password = passwordEncoder.encode(createUserArguments.password),
        )

        val createdUser = userRepository.save(user)

        val token = jwtPlugin.generateAccessToken(
            subject = user.id.toString(),
            username = user.username,
        )

        return UserDto.from(createdUser, token)
    }

    override fun signIn(signInArguments: SignInArguments): UserDto {
        val user = userRepository.findByUsername(signInArguments.username)
            ?: throw Exception("user is not found")

        if (user.username != signInArguments.username ||
            !passwordEncoder.matches(signInArguments.password, user.password)
        ) {
            throw Exception("authentication failed")
        }

        val token = jwtPlugin.generateAccessToken(
            subject = user.id.toString(),
            username = user.username,
        )

        return UserDto.from(user, token)
    }
}
