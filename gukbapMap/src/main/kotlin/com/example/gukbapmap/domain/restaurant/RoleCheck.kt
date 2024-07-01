package com.example.gukbapmap.domain.restaurant

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class RoleCheck(val value: String = "ADMIN")

