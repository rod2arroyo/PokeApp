package com.example.pokeapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class APIResponsePoke (
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokeResult>,
)
data class PokeResult (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("stats") val stats: List<Stat>,
    @Expose @SerializedName("sprites") val sprites: Sprites
)

data class Stat(
    @Expose @SerializedName("base_stat") val base_stat: Int
)

data class Sprites(
    @Expose @SerializedName("front_default") val frontDefault: String,
)