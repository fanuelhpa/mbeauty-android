package com.fandevv.mbeauty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.101.3:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}