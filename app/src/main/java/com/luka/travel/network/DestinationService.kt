package com.luka.travel.network

import androidx.viewbinding.BuildConfig
import com.luka.travel.model.DestinationResponse
import com.luka.travel.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DestinationService {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
//        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
        const val CLIENT_ID = "fsG_1uG3gjlGBFGH0ChpR8Db6InSFJk6NxNKbg39Ewk"

    }

    @GET("location")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): LocationResponse

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): DestinationResponse

}
