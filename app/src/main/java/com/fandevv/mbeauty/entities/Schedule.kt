package com.fandevv.mbeauty.entities

data class Schedule(
    val id: Int,
    val paymentDate: String,
    val price: Double,
    val schedulingDate: String,
    val service: Service,
    val user: User
)