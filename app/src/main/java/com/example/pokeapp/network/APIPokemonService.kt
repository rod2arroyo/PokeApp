package com.example.pokeapp.network

import com.example.pokeapp.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface APIPokemonService {
    @GET("pokemon")
    fun getAllPokemon() : Call<List<Pokemon>>
}