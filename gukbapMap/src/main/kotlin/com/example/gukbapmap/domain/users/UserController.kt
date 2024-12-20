package com.example.gukbapmap.domain.users

import com.example.gukbapmap.domain.users.dtos.CreateUserArguments
import com.example.gukbapmap.domain.users.dtos.SignInArguments
import com.example.gukbapmap.domain.users.dtos.UserDto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/users")
@RestController
class UserController(
    val userService: UserService,
) {
    @PostMapping
    fun createUser(
        @RequestBody createUserArguments: CreateUserArguments,
    ): ResponseEntity<UserDto> {
        val user = userService.createUser(createUserArguments)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(user)
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInArguments): ResponseEntity<UserDto> {
        val result = userService.signIn(signInRequest)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(result)
    }
}
