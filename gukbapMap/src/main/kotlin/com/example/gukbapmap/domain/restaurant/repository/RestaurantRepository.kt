package com.example.gukbapmap.domain.restaurant.repository

import com.example.gukbapmap.domain.restaurant.model.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository :JpaRepository<Restaurant, Long>
