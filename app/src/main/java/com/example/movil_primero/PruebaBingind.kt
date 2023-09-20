package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movil_primero.databinding.ActivityPruebaBingindBinding

class PruebaBingind : AppCompatActivity() {
    private lateinit var binding: ActivityPruebaBingindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_prueba_bingind)

        binding = ActivityPruebaBingindBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}