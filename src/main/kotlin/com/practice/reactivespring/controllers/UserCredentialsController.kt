package com.practice.reactivespring.controllers

import com.practice.reactivespring.dto.UserCredentialsData
import com.practice.reactivespring.service.UserCredentialsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-credentials")
class UserCredentialsController(
    private val userCredentialsService: UserCredentialsService
) {

    @PostMapping("/")
    fun save(@RequestBody userCredentialsData: UserCredentialsData) : ResponseEntity<*>{
        return ResponseEntity.ok(
            userCredentialsService.saveUserCredentials(userCredentialsData)
        )
    }

    @GetMapping("/")
    fun getAll(): ResponseEntity<*>{
        return ResponseEntity.ok(
            userCredentialsService.getAllUserCredentials()
        )
    }

}