package com.example.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.*

class SpecsFragment : Fragment(){
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
        return inflater.inflate(R.layout.fragment_specs,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //favoritos
        val btnAgregarfavorito = view.findViewById<Button>(R.id.buttonfavorito)
        btnAgregarfavorito.setOnClickListener{ _ : View ->
            num[const] = 1

            buscarlosfavoritos()
            //   listener?.OnClick("createRecipe")
        }
        //datos pokemon actual
        var nombre = view.findViewById<TextView>(R.id.txtnombrefvorito)
        nombre?.text = pokemonactual.name

        var hp = view.findViewById<TextView>(R.id.texthpfavorito)
        hp?.text = pokemonactual.url.toString()
    }



}