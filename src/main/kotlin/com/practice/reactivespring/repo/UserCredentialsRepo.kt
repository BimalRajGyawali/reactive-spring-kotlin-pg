package com.practice.reactivespring.repo

import com.practice.reactivespring.models.UserCredentials
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserCredentialsRepo : ReactiveCrudRepository<UserCredentials, Int>{
    fun findByUsername(username: String): Mono<UserCredentials>
}