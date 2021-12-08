package com.Abdul.data

import com.Abdul.database.UserDB
import retrofit2.Call
import retrofit2.http.GET

interface RandomDataApi {
    @GET("/api/nation/random_nation?size=15")
    fun getNation(): Call<List<UserDB>>
}