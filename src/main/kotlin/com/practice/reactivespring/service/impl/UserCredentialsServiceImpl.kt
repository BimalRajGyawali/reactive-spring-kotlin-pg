package com.practice.reactivespring.service.impl

import com.practice.reactivespring.dto.UserCredentialsData
import com.practice.reactivespring.models.UserCredentials
import com.practice.reactivespring.repo.UserCredentialsRepo
import com.practice.reactivespring.service.UserCredentialsService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserCredentialsServiceImpl(
     val userCredentialsRepo: UserCredentialsRepo
) : UserCredentialsService{

    override fun saveUserCredentials(userCredentialsData: UserCredentialsData): Mono<UserCredentialsData> {
        val userCredentials = UserCredentials(username = userCredentialsData.username,
            password = userCredentialsData.password)

       return userCredentialsRepo.save(userCredentials)
           .map { UserCredentialsData(
               it.username,it.password
           ) }

    }

    override fun getUserCredential(username: String): Mono<UserCredentialsData> {
        return userCredentialsRepo.findByUsername(username)
            .map { UserCredentialsData(
                it.username, it.password
            ) }
    }

    override fun getAllUserCredentials(): Flux<UserCredentialsData> {
        return userCredentialsRepo.findAll()
            .map { UserCredentialsData(
                it.username, it.password
            ) }
    }
}