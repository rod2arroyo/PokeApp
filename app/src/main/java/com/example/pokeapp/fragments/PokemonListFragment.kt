package com.example.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.*
import com.example.pokeapp.adpter.PokemonListAdapter
import com.example.pokeapp.adpter.pokelistadapter
import com.example.pokeapp.model.Pokemon
import com.example.pokeapp.model.PokemonLista
import com.example.pokeapp.model.PokemonManager
import com.example.pokeapp.poke.pokemones

class PokemonListFragment: Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface OnMenuClicked{
        fun OnClick(menuName: String)
        //fun onSelect(pokemon : Pokemon)
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
        return inflater.inflate(R.layout.fragment_pokelist,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rviPokemon = view.findViewById<RecyclerView>(R.id.rviPokemon)

       PokemonManager().getPokemonRetrofit({pkList : PokemonLista ->
            rviPokemon.adapter = PokemonListAdapter(
                pkList,
                this
            ){pokemon : Pokemon ->
                Log.i("PokeFragmentList",pokemon.name)
                listener?.OnClick("verinfo")
            }
        },{error ->
            Toast.makeText(activity,"Error" + error,Toast.LENGTH_SHORT).show()
        })

        /*PokemonManager().getPokemones({pkList ->
            val rviPokemon = view.findViewById<RecyclerView>(R.id.rviPokemon)
            rviPokemon.adapter = PokemonListAdapter(
                pkList
            ){pokemon : Pokemon ->
                Log.i("PokeFragmentList",pokemon.name)
                listener?.OnClick("verinfo")
            }
        },{error ->
            Toast.makeText(activity,"Error" + error,Toast.LENGTH_SHORT).show()
        })*/


        /*val rviPokemon = view.findViewById<RecyclerView>(R.id.rviPokemon)
        var listaconst : ArrayList<pokemones> = arrayListOf()

        if (ventana =="favoritos"){
            listaconst = listafavoritos
        }else{
            listaconst = listanueva
        }

        rviPokemon.adapter = pokelistadapter(
            listaconst
        ) { pokemon: pokemones ->
            pokemonactual = pokemon
            pokemon.favorito=1
         //   pokemonactual.favorito =1
        //    buscarlosfavoritos()
            Log.i("mamahuevoooo",pokemon.nombre)
            listener?.OnClick("verinfo")
        }*/

    }
}