package com.example.pokeapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.buscarlosfavoritos
import com.example.pokeapp.listafavoritos
import com.example.pokeapp.listanueva
import com.example.pokeapp.model.PokeResult
import com.example.pokeapp.poke.pokemones



class favoritepokeadapter(
    private val recipeList : List<PokeResult>,
    private val listener : (PokeResult) -> Unit) :
    RecyclerView.Adapter<favoritepokeadapter.ViewHolder>() {
    class ViewHolder(view: View, val listener :(PokeResult) -> Unit, val recipeList : List<PokeResult>) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val nombre: TextView
        val bute: Button

        init {
            nombre = view.findViewById(R.id.textpokemonfavorito)
            bute = view.findViewById(R.id.buteliminarfavorito)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener(recipeList[adapterPosition])
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorito, parent,false)

        val viewHolder = ViewHolder(view,listener,recipeList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.txtUser.text = recipeList[position].usuario
        // holder.txtRecipeName.text = recipeList[position].nombre
        //holder.ingrediente.text = recipeList[position].nombre

        holder.nombre.text = recipeList[position].name
        holder.bute.setOnClickListener{ _ : View ->

            println("----------->>> eliminar favoirto-------->>>>" + holder.nombre.text )

//            for(i in 0..(listafavoritos.size-1)){
//
//                if(listafavoritos[i].nombre==holder.nombre.text){
//                    //listafavoritos.removeadd(listafavoritos[i])
//                   // listafavoritos.removeAt(i)
//                    println("pokkemones remove..->"+ listafavoritos[i].nombre)
//                }
//            }
            for(i in 0..(listanueva.size-1)){
                if(listanueva[i].nombre==holder.nombre.text){
                    listanueva[i].favorito=0
                    println("pokkemones cambiado en lista normal..->"+ listanueva[i].nombre)
                }
            }
            buscarlosfavoritos()





        }

    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}