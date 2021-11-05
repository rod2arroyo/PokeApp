package com.example.pokeapp.network

import com.example.pokeapp.model.APIResponsePoke
import com.example. pokeapp.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIPokemonService {
    @GET("pokemon/{name}")
    fun getPokemonStats(@Path("name") name: String): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<APIResponsePoke>
}