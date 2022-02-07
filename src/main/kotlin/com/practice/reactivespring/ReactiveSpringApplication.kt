package com.practice.reactivespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveSpringApplication

fun main(args: Array<String>) {
    runApplication<ReactiveSpringApplication>(*args)
}
