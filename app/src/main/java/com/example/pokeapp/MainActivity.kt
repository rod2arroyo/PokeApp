package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pokeapp.fragments.PokemonListFragment
import com.example.pokeapp.fragments.SpecsFragment
import com.example.pokeapp.poke.pokemones
import kotlin.math.ln


var listanueva : ArrayList<pokemones> = arrayListOf()
var listafavoritos : ArrayList<pokemones> = arrayListOf()
var pika  = pokemones("pikachu",20,0)
var dra  = pokemones("dragon",55,0)
var pokemonactual  = pokemones("null", 0 , 0 )
var ventana = ""


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


class MainActivity : AppCompatActivity() , PokemonListFragment.OnMenuClicked ,SpecsFragment.OnMenuClicked{
    private val fragments = mutableListOf<Fragment>()



    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragments.add(PokemonListFragment())
        fragments.add(SpecsFragment())


        if(ventana=="favoritos"){
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragments[0])
            println("-------------------------------------------------------------------------------------")
            ft.commit()
        }else{
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragments[0])
            ft.commit()
        }



    }

    fun changeCreateRecipe(){
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }




    override fun OnClick(menuName: String) {
        if(menuName == "verinfo"){
            changeCreateRecipe()

        }
    }


}

