package com.example.pokeapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.R
import com.example.pokeapp.model.PokeResult
import com.example.pokeapp.model.Pokemon
import com.example.pokeapp.model.PokemonLista

class PokemonListAdapter (
    private val pokemonList : List<PokeResult>,
    private val fragment: Fragment,
    private val listener : (PokeResult) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

        class ViewHolder(view: View, val listener :(PokeResult) -> Unit,
            val pokemonList : List<PokeResult>) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val imagen : ImageView
            val nombre: TextView
            val ataque: TextView

            init {
                imagen = view.findViewById(R.id.imgRecipe)
                nombre = view.findViewById(R.id.texthp)
                ataque = view.findViewById(R.id.textattack)
                view.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                listener(pokemonList[adapterPosition])
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
        holder.nombre.text = pokemonList[position].name
        holder.ataque.text = pokemonList[position].url
        val partes : List<String> =  pokemonList[position].url.split("/")
        val id : String = partes[partes.size-2]

        Glide.with(fragment)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png")
            .override(600,200)
            .fitCenter()
            .into(holder.imagen)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}