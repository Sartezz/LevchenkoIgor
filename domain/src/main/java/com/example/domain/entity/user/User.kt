package com.example.domain.entity.user

data class User(
    var id: Int,
    var name: String,
    var userName: String,
    var email: String,
    var address: Address,
    var phone: String,
    var website: String,
    var company: Company
)