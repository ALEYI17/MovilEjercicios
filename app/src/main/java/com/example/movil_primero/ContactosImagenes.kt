package com.example.movil_primero

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.movil_primero.databinding.ActivityContactosImagenesBinding
import com.example.movil_primero.databinding.ActivityPruebaBingindBinding

class ContactosImagenes : AppCompatActivity() {
    private lateinit var binding: ActivityContactosImagenesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_contactos_imagenes)
        binding = ActivityContactosImagenesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton3.setOnClickListener(){
            var intentImagenes= Intent(baseContext,GaleriaActivity::class.java)
            startActivity(intentImagenes)
        }
        binding.imageButton2.setOnClickListener(){
            var intentContactos= Intent(baseContext,listaContactos::class.java)
            startActivity(intentContactos)
        }
    }
}