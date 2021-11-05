package com.example.pokeapp.model

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
import java.util.logging.Handler

class PokemonManager {
    var results = ArrayList<Pokemon>()
    val TAG = "POKEDEX"
    val API_URL = "https://pokeapi.co/api/v2/"

    fun getPokemones(callbackOk : (List<Pokemon>)-> Unit, callbackError : (String) -> Unit) : List<Pokemon>{
        val networkClient = NetworkClient("")

        val handler = HandlerCompat.createAsync(Looper.myLooper()!!)
        networkClient.download({data: String ->
            //  ok
            val collecionType = object : TypeToken<Collection<Pokemon>>(){}.type
            val gson = Gson()
            var listPokemon = gson.fromJson<List<Pokemon>>(data,collecionType)
            handler.post{
                callbackOk(listPokemon)
            }
            },{ error : String ->
            //  error
            handler.post{
                callbackError(error)
            }
        })

        val pokemones = arrayListOf<Pokemon>()
        return pokemones
    }

    fun getPokemonRetrofit(callbackOk : (PokemonLista)-> Unit, callbackError : (String) -> Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service : APIPokemonService = retrofit.create(APIPokemonService::class.java)
        var pokemonResponse = service.getAllPokemon()
        pokemonResponse.enqueue(object: Callback<PokemonLista>{
            override fun onResponse(call: Call<PokemonLista>, response: Response<PokemonLista>) {
                if(response.isSuccessful){
                    var pokemonRespuesta  = response.body()
                    var pokeList = pokemonRespuesta!!.results
                    for (i in 0 until pokeList.size){
                        var p : Pokemon = pokeList[i]
                        Log.i(TAG,"Pokemon" + p.url)
                    }
                }else{
                    Log.e(TAG, "oNresponse: " + response.errorBody())
                }
            }
            override fun onFailure(call: Call<PokemonLista>, t: Throwable) {
                Log.e(TAG," Onfailure" + t!!.message)
            }
        })
    }
}