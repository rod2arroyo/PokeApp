package com.example.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.*
import com.example.pokeapp.adpter.pokelistadapter
import com.example.pokeapp.poke.pokemones



class PokemonListFavoriteFragment: Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface OnMenuClicked{
        fun OnClick(menuName: String)
    }

    private var listener: OnMenuClicked? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnMenuClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ACTIVITY = context as MainActivity
        return inflater.inflate(R.layout.fragment_pokelist,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviPokemon = view.findViewById<RecyclerView>(R.id.rviPokemon)
        listafavoritos.add(pika)
        listafavoritos.add(dra)


        //rviRecipes.adapter = RecipeListAdapter(ACTIVITY.recetasManager.getRecetas()
        rviPokemon.adapter = pokelistadapter(
            listafavoritos

        ) { pokemon: pokemones ->

            pokemonactual = pokemon

            Log.i("mamahuevoooo",pokemon.nombre)

            listener?.OnClick("verinfo")

        }

    }
}