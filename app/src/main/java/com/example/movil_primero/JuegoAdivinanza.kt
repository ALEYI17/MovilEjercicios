package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movil_primero.databinding.ActivityJuegoAdivinanzaBinding
import kotlin.random.Random

class JuegoAdivinanza : AppCompatActivity() {
    private lateinit var binding: ActivityJuegoAdivinanzaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_juego_adivinanza)

        binding= ActivityJuegoAdivinanzaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var numeroAleatorio = Random.nextInt(0, 1001)


        binding.button5.setOnClickListener(){
            val ganador = adinino(numeroAleatorio)
            if (ganador == true) numeroAleatorio = Random.nextInt(0, 1001)
        }
    }

    private fun adinino(numeroAleatorio: Int) :Boolean{
        Log.i("LOCATION", "numero: " + numeroAleatorio)
        val textoIngresado = binding.editTextNumber2.text.toString()

        if (textoIngresado.isNotEmpty()) {
            val numeroIngresado = textoIngresado.toInt()

            if (numeroIngresado == numeroAleatorio) {
                binding.textView8.text = "Ganaste, adivina otro numero"
                return true
            }
            else if(numeroIngresado < numeroAleatorio) {
                binding.textView8.text = "El numero es mas arriba"
            }
            else if(numeroIngresado > numeroAleatorio) {
                binding.textView8.text = "El numero es mas bajo"
            }
        }
        else {
            binding.textView8.text = "Ingresa un numero"
        }
        return false
    }
}