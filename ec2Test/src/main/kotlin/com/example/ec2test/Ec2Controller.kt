package com.example.ec2test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Ec2Controller {

    @GetMapping
    fun testMan() : String{
        return "연결완료!"
    }
}