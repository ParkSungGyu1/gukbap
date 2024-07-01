package com.example.gukbapmap.domain.restaurant.dtos

import com.example.gukbapmap.domain.users.dtos.UserDto

data class RestaurantResponse (
    val id : Long?,
    val x : String,
    val y : String,
    val user: UserDto
)