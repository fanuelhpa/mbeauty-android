package com.fandevv.mbeauty.entities

import com.google.gson.annotations.SerializedName

data class Schedule(
    val id: Int,
    val scheduleDate: String,
    val price: Double,
    @SerializedName("userDTO")
    val user: User,
    @SerializedName("serviceDTO")
    val service: Service
)
