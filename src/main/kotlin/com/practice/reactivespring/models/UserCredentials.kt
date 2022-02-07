package com.practice.reactivespring.models

import org.springframework.data.annotation.Id
    import org.springframework.data.relational.core.mapping.Table

@Table("user_credentials")
class UserCredentials(
    @Id
    var id: Int = 0,

    val username: String,

    val password: String
)