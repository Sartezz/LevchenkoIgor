package com.example.data.db.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDB(
    @PrimaryKey
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: AddressDB,
    var phone: String,
    var website: String,
    var company: CompanyDB
)