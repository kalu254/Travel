package com.luka.travel.network

import com.luka.travel.model.UserResponse
import com.squareup.moshi.Moshi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/users")
    suspend fun getListData(@Query("page") pageNumber: Int): Response<UserResponse>

    companion object {


        fun getApiService(): UserService = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }

}
