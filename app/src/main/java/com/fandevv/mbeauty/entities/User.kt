package com.fandevv.mbeauty.entities

data class User(
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val phones: List<Phone>,
    val userType: String
)