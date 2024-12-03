package com.example.gukbapmap.domain.restaurant.controller

import com.example.gukbapmap.domain.restaurant.dtos.RestaurantRequest
import com.example.gukbapmap.domain.restaurant.dtos.RestaurantResponse
import com.example.gukbapmap.domain.restaurant.service.RestaurantService
import com.example.gukbapmap.securities.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/restaurant")
@RestController
class RestaurantController (
    private val restaurantService: RestaurantService
) {

    @GetMapping
    fun getRestaurants() : ResponseEntity<List<RestaurantResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getRestaurants())
    }

    @PostMapping
    fun registerRestaurant(
        @RequestBody restaurantRequest: RestaurantRequest,
        authentication: Authentication
    ) : ResponseEntity<Unit>{
        restaurantService.registerRestaurant(restaurantRequest, authentication.principal as UserPrincipal)
        return ResponseEntity.status(HttpStatus.CREATED).body(null)
    }
}