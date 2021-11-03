package com.example.pokeapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        val btnFavoritos : Button = findViewById(R.id.btnFavoritos)


        listanueva.add(pika)
        listanueva.add(dra)
        btnContinuar.setOnClickListener { _: View ->
            val intent: Intent = Intent()
            ventana = "normal"
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)

        }

        btnFavoritos.setOnClickListener{_ : View ->
            val intent: Intent = Intent()
            ventana = "favoritos"
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)


            for(i in 0..(listafavoritos.size-1)){

                println("pokkemones en favorito..--------->"+ listafavoritos[i].nombre)
            }
        }
    }
}