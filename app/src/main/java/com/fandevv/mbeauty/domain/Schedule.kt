package com.fandevv.mbeauty.domain

import com.google.gson.annotations.SerializedName

data class Schedule(
    val id: Int,
    val date: String,
    val hour: String,
    val price: Double,
    val user: User,
    val service: Service
)
