package com.practice.reactivespring.service

import com.practice.reactivespring.dto.UserCredentialsData
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserCredentialsService{

    fun saveUserCredentials(userCredentialsData: UserCredentialsData): Mono<UserCredentialsData>

    fun getUserCredential(username: String): Mono<UserCredentialsData>

    fun getAllUserCredentials(): Flux<UserCredentialsData>
}