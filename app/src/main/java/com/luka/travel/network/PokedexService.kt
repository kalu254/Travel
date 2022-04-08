package com.luka.travel.network

import com.luka.travel.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexService {

    @GET("location")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): LocationResponse

}
