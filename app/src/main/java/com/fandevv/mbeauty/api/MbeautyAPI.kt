package com.fandevv.mbeauty.api

import com.fandevv.mbeauty.domain.Schedule
import retrofit2.Response
import retrofit2.http.GET

interface MbeautyAPI {

    @GET("/schedules")
    suspend fun findSchedules() : Response<List<Schedule>>

}