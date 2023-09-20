package com.example.movil_primero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class calculadoraFibonacci : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_fibonacci)

        var clacularBoton = findViewById<Button>(R.id.button4)

        clacularBoton.setOnClickListener(){
            var intentCalcular = Intent(baseContext,listaFibonacci::class.java)
            val numeroTexto = findViewById<EditText>(R.id.editTextNumber)
            val texto = numeroTexto.text.toString() // Obtener el texto del EditText como String

            // Intentar convertir el texto a un Int
            val numero: Int? = try {
                texto.toInt()
            } catch (e: NumberFormatException) {
                null // En caso de que no se pueda convertir, asignar null
            }

            if (numero != null) {

                val resultado = fibonacci(numero)
                intentCalcular.putExtra("FibonacciList", ArrayList(resultado))
                startActivity(intentCalcular)
            }


        }
    }

    fun fibonacci(n: Int): List<Int> {
        val fibonacciList = mutableListOf<Int>()

        for (i in 0 until n) {
            if (i <= 1) {
                fibonacciList.add(i)
            } else {
                val nextFibonacci = fibonacciList[i - 1] + fibonacciList[i - 2]
                fibonacciList.add(nextFibonacci)
            }
        }

        return fibonacciList
    }
}