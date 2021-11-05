package com.example.pokeapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.poke.pokemones

class pokelistadapter(
    private val recipeList : List<pokemones>,
    private val listener : (pokemones) -> Unit) :
    RecyclerView.Adapter<pokelistadapter.ViewHolder>() {
    class ViewHolder(view: View, val listener :(pokemones) -> Unit, val recipeList : List<pokemones>) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val nombre: TextView
        val ataque: TextView

        init {
            nombre = view.findViewById(R.id.texthp)
            ataque = view.findViewById(R.id.textattack)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener(recipeList[adapterPosition])
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent,false)

        val viewHolder = ViewHolder(view,listener,recipeList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.txtUser.text = recipeList[position].usuario
        // holder.txtRecipeName.text = recipeList[position].nombre
        //holder.ingrediente.text = recipeList[position].nombre

        holder.nombre.text = recipeList[position].nombre
        holder.ataque.text = recipeList[position].favorito.toString()

    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}