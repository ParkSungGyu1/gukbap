package com.example.gukbapmap.domain.restaurant.service

import com.example.gukbapmap.domain.restaurant.RoleCheck
import com.example.gukbapmap.domain.restaurant.dtos.RestaurantRequest
import com.example.gukbapmap.domain.restaurant.dtos.RestaurantResponse
import com.example.gukbapmap.securities.UserPrincipal

interface RestaurantService {
    fun registerRestaurant(restaurantRequest: RestaurantRequest, userPrincipal: UserPrincipal)
    fun getRestaurants(): List<RestaurantResponse>
}