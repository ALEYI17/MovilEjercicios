package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class listaFibonacci : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_fibonacci)

        val fibonacciList = intent.getIntegerArrayListExtra("FibonacciList")

        if (fibonacciList != null) {
            // Haz algo con la lista recibida, por ejemplo, muestra los números en un ListView
            val listView = findViewById<ListView>(R.id.listView)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fibonacciList)
            listView.adapter = adapter
        } else {
            // Maneja el caso en el que no se pasó una lista válida
        }
    }
}