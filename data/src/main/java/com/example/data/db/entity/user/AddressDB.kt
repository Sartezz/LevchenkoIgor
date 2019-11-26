package com.example.data.db.entity.user

data class AddressDB (
    var street: String,
    var suite: String,
    var city: String,
    var zipcode: String,
    var geo: GeoDB
)