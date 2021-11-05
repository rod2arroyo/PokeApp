package com.example.pokeapp.model

import android.content.Context
import android.os.Looper
import android.util.Log
import androidx.core.os.HandlerCompat
import com.example.pokeapp.network.APIPokemonService
import com.example.pokeapp.network.NetworkClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

val datos = ArrayList<String>()

class PokemonManager(context: Context) {
    var results = ArrayList<Pokemon>()
    val TAG = "POKEDEX"
    val API_URL = "https://pokeapi.co/api/v2/"

    val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : APIPokemonService = retrofit.create(APIPokemonService::class.java)

    fun getPokemonRetrofit(callBackOK: (APIResponsePoke) -> Unit, callBackError: (Any) -> Unit) {
        val call = service.getPokemonList(20,0)
        call.enqueue(object: Callback<APIResponsePoke>{
            override fun onResponse(
                call: Call<APIResponsePoke>,
                response: Response<APIResponsePoke>
            ) {
                callBackOK(response.body()!!)
            }

            override fun onFailure(call: Call<APIResponsePoke>, t: Throwable) {
                Log.e("Manager: ", t.message!!)
                callBackError(t.message!!)
            }

        })
    }
}