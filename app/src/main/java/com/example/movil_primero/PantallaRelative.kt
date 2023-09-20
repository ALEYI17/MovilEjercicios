package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast

class PantallaRelative : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val spinner1:Spinner = findViewById(R.id.textView)
        val spinner2:Spinner = findViewById(R.id.textView2)

        spinner1.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val nivel = parent.selectedItem
        Toast.makeText(this,"Se selecciono" + parent.selectedItemPosition + "Objeto seleccionado" + nivel , Toast.LENGTH_SHORT).show()

        Log.i("PantallaRelative" , pos.toString())
        Log.i("PantallaRelativeid" , id.toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }
}