package com.example.movil_primero

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class AdapterContactos(context: Context, c: Cursor?,flags: Int): CursorAdapter(context,c,flags) {

    private val CONTACT_ID_INDEX = 0
    private val DISPLAY_NAME_INDEX = 1

    override fun newView(p0: Context?, p1: Cursor?, p2: ViewGroup?): View {
        return LayoutInflater.from(p0).inflate(R.layout.adapter_contactos,p2,false)
    }

    override fun bindView(p0: View?, p1: Context?, p2: Cursor?) {
        val tvIdContacto = p0?.findViewById<TextView>(R.id.contacto)
        val tvIdNombre = p0?.findViewById<TextView>(R.id.nombre)
        val idNum = p2?.getInt(CONTACT_ID_INDEX)
        val nombre = p2?.getString(DISPLAY_NAME_INDEX)
        tvIdContacto?.text = idNum?.toString()
        tvIdNombre?.text = nombre
    }


}