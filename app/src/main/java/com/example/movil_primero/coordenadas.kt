package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class coordenadas : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordenadas)

        val longitud = intent.getStringExtra("locationLongitude")
        val latitud = intent.getStringExtra("locationLatitude")
        val altitude = intent.getStringExtra("locationElevation")

        val textoLongitud = findViewById<TextView>(R.id.longitud)
        textoLongitud.text = longitud
        Log.i("LOCATION", "Latitud: " + latitud)
        val textoLatituf = findViewById<TextView>(R.id.latitud)
        textoLatituf.text = latitud

        val altitud = findViewById<TextView>(R.id.altitud)
        altitud.text = altitude



    }
}