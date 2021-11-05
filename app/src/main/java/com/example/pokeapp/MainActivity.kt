package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.pokeapp.fragments.PokemonListFavoriteFragment
import com.example.pokeapp.fragments.PokemonListFragment
import com.example.pokeapp.fragments.SpecsFragment
import com.example.pokeapp.model.PokeResult
import com.example.pokeapp.model.Pokemon
import com.example.pokeapp.model.PokemonManager
import com.example.pokeapp.network.APIPokemonService
import com.example.pokeapp.poke.pokemones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.ln

var listanueva : ArrayList<pokemones> = arrayListOf()
var listafavoritos : ArrayList<pokemones> = arrayListOf()
var pika  = pokemones("pikachu",20,0)
var dra  = pokemones("dragon",55,0)
var pokemonactual  = PokeResult("",  "")
var ventana = ""
var listaFav : ArrayList<PokeResult> = arrayListOf()
var num = IntArray(20)
var ultimalista : List<PokeResult> = arrayListOf()

var const : Int = 0
fun buscarlosfavoritos( ){
    var lista : ArrayList<pokemones> = arrayListOf()
    for(i in 0..(listanueva.size-1)){
        if(listanueva[i].favorito==1){
            lista.add(listanueva[i])
            println("pokkemones en favorito..->"+ listanueva[i].nombre)
        }
    }
    listafavoritos=lista
}

class MainActivity : AppCompatActivity() , PokemonListFragment.OnMenuClicked ,SpecsFragment.OnMenuClicked, PokemonListFavoriteFragment.OnMenuClicked{
    var TAG = "POKEDEX"
    private val fragments = mutableListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(PokemonListFragment())
        fragments.add(PokemonListFavoriteFragment())
        fragments.add(SpecsFragment())

        if(ventana=="favoritos"){
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragments[1])
            println("-------------------------------------------------------------------------------------")
            ft.commit()
        }else{
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragments[0])
            ft.commit()
        }
    }

    fun changeCreateRecipe(){
        val fragment = fragments[2]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }
    fun verfavorito(){
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }

    override fun OnClick(menuName: String) {
        if(menuName == "verinfo"){
            changeCreateRecipe()
        }
        else if(menuName == "favoritoop"){
            verfavorito()
        }
        else if(menuName == "pokes"){
            verpokes()
        }
    }
    fun verpokes(){

        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)

        ft.commit()
    }

}
