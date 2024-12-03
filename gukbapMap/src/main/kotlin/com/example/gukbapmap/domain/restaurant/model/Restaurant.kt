package com.example.gukbapmap.domain.restaurant.model

import com.example.gukbapmap.domain.restaurant.dtos.RestaurantRequest
import com.example.gukbapmap.domain.restaurant.dtos.RestaurantResponse
import com.example.gukbapmap.domain.users.User
import com.example.gukbapmap.domain.users.dtos.UserDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Restaurant (

    @Column
    val x: String,

    @Column
    val y: String,

    @Column
    val review: String?,

    @ManyToOne
    val user:User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?=null

    fun to() : RestaurantResponse{
        return RestaurantResponse(
            id, x, y, review, UserDto.from(user)
        )
    }

    companion object {
        fun from(restaurantRequest: RestaurantRequest, user: User) : Restaurant{
            return Restaurant(
                x = restaurantRequest.x,
                y = restaurantRequest.y,
                review = restaurantRequest.review,
                user = user
            )

        }

    }
}
