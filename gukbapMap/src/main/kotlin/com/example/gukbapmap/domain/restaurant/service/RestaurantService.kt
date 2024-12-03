package com.example.gukbapmap.domain.restaurant.service

import com.example.gukbapmap.domain.restaurant.dtos.RestaurantRequest
import com.example.gukbapmap.domain.restaurant.dtos.RestaurantResponse
import com.example.gukbapmap.domain.restaurant.model.Restaurant
import com.example.gukbapmap.domain.restaurant.repository.RestaurantRepository
import com.example.gukbapmap.domain.users.UserRepository
import com.example.gukbapmap.securities.UserPrincipal
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    private val restaurantRepository: RestaurantRepository,
    private val userRepository: UserRepository
){
    fun getRestaurants(): List<RestaurantResponse> {
        return restaurantRepository.findAll().map { it.to() }
    }

    fun registerRestaurant(restaurantRequest: RestaurantRequest, userPrincipal: UserPrincipal) {
        val user = userRepository.findByUsername(userPrincipal.username)?: throw Exception("userNotFound")
        val restaurant = Restaurant.from(restaurantRequest, user)
        restaurantRepository.save(restaurant)
    }
}