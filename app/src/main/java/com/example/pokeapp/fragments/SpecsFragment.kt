package com.example.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.MainActivity
import com.example.pokeapp.R

//class SpecsFragment : Fragment(){
//    lateinit var ACTIVITY : MainActivity
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        ACTIVITY = context as MainActivity
//        return inflater.inflate(R.layout.fragment_specs,container,false)
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//}


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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var textoop = view.findViewById<TextView>(R.id.nombreseleccionado)
//        textoop?.text = nombregalleta
//
//
//
//        val recycleringredients = view.findViewById<RecyclerView>(R.id.recetaseleccionada)
//
//        recycleringredients.adapter = viewrecipecookieAdapter(listaselecciongalleta)
//
//    }



}