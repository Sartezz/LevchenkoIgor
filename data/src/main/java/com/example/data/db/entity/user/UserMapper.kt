package com.example.data.db.entity.user

import com.example.domain.entity.user.Address
import com.example.domain.entity.user.Company
import com.example.domain.entity.user.Geo
import com.example.domain.entity.user.User

fun User.transformToUserDb() = UserDB(
    id,
    name,
    username,
    email,
    address.transformToAddressDB(),
    phone,
    website,
    company.transformToCompanyDB()
)

fun UserDB.transformToUser() = User(
    id,
    name,
    username,
    email,
    address.transformToAddress(),
    phone,
    website,
    company.transformToCompany()
)


fun Company.transformToCompanyDB() = CompanyDB(name, catchPhrase, bs)
fun Geo.transformToGeoDB() = GeoDB(lat, lng)
fun Address.transformToAddressDB() =
    AddressDB(street, suite, city, zipcode, geo = geo.transformToGeoDB())

fun CompanyDB.transformToCompany() = Company(name, catchPhrase, bs)
fun GeoDB.transformToGeo() = Geo(lat, lng)
fun AddressDB.transformToAddress() =
    Address(street, suite, city, zipcode, geo = geo.transformToGeo())


