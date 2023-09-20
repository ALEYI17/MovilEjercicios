package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val text2:TextView = findViewById(R.id.Texto2)

        var nombre = intent.getStringExtra("Texto")

        if (nombre != null){
            Log.i("Prueba pantalla2","Lo que esta llegando" + nombre)
        }
        text2.text = nombre


    }
}