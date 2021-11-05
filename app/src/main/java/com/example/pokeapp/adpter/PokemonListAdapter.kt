package com.example.pokeapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.model.Pokemon
import com.example.pokeapp.model.PokemonLista

class PokemonListAdapter (
    private val pokemonList : PokemonLista,
    private val fragment: Fragment,
    private val listener : (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

        class ViewHolder(view: View, val listener :(Pokemon) -> Unit,
            val pokemonList : PokemonLista) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val nombre: TextView
            val ataque: TextView

            init {
                nombre = view.findViewById(R.id.texthp)
                ataque = view.findViewById(R.id.textattack)
                view.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                listener(pokemonList.results[adapterPosition])
            }

        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent,false)

        val viewHolder = ViewHolder(view, listener, pokemonList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.txtUser.text = recipeList[position].usuario
        // holder.txtRecipeName.text = recipeList[position].nombre
        //holder.ingrediente.text = recipeList[position].nombre
        holder.nombre.text = pokemonList.results[position].name
        holder.ataque.text = pokemonList.results[position].url
    }

    override fun getItemCount(): Int {
        return pokemonList.results.size
    }
}