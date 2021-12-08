package com.Abdul.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

        // 1)//https://random-data-api.com/api/users/random_user
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://random-data-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 2)
        fun getRandomDataApi(): RandomDataApi = retrofit.create(RandomDataApi::class.java)
}