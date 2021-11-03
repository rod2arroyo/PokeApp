package com.example.pokeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pokeapp.fragments.PokemonListFavoriteFragment
import com.example.pokeapp.fragments.PokemonListFragment
import com.example.pokeapp.fragments.SpecsFragment

class FavActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)
    }
}

//class FavActivity : AppCompatActivity() , PokemonListFragment.OnMenuClicked,SpecsFragment.OnMenuClicked{
//    private val fragments = mutableListOf<Fragment>()
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fav)
//
//
//        fragments.add(PokemonListFragment())
//        fragments.add(SpecsFragment())
//
//
//
//        val ft = supportFragmentManager.beginTransaction()
//        ft.add(R.id.flaContent,fragments[0])
//        ft.commit()
//    }
//
//
//
//    fun changeCreateRecipe(){
//        val fragment = fragments[0]
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.flaContent,fragment)
//        ft.commit()
//    }
//
//
//
//    override fun OnClick(menuName: String) {
//        if(menuName == "verinfo"){
//            changeCreateRecipe()
//        }
//    }
//
//
//
//}