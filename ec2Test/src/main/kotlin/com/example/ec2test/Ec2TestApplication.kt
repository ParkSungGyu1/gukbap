package com.example.ec2test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ec2TestApplication

fun main(args: Array<String>) {
    runApplication<Ec2TestApplication>(*args)
}
