package com.example.movil_primero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Text1:TextView = findViewById(R.id.titulo1)
        val Text2:TextView = findViewById(R.id.titulo2)

        Text1.text = "Pontificia universidad Franciscana"


        val botonToast:Button = findViewById(R.id.button2)
        val botonGps : Button = findViewById(R.id.gps)


        val textoqueCambia : EditText = findViewById(R.id.cambio)
        val boton3:Button = findViewById(R.id.button3)
        val BotonRelative:Button= findViewById(R.id.relative)
        val Botonfibo:Button= findViewById(R.id.fibo)
        val Botonpermi:Button= findViewById(R.id.permi)
        val Botonjuego:Button= findViewById(R.id.juego)
        val Botoncoordetiempo:Button= findViewById(R.id.coordetiempo)
        val intent2:Intent = Intent(this,PantallaRelative::class.java)

        val intent:Intent = Intent(this,Activity2::class.java)
        val botonWeb:Button = findViewById(R.id.webee)


        Botoncoordetiempo.setOnClickListener(){
            val intentcorde:Intent = Intent(this, CoordenadasTiempo::class.java)
            startActivity(intentcorde)
        }
        Botonjuego.setOnClickListener(){
            val intentJuego:Intent = Intent(this, JuegoAdivinanza::class.java)
            startActivity(intentJuego)
        }
        Botonfibo.setOnClickListener(){
            val intentfibo:Intent = Intent(this, calculadoraFibonacci::class.java)
            startActivity(intentfibo)
        }
        Botonpermi.setOnClickListener(){
            val intentpermi:Intent = Intent(this, ContactosImagenes::class.java)
            startActivity(intentpermi)
        }



        botonGps.setOnClickListener(){
            val intent2:Intent = Intent(this, GpsCoordenadas::class.java)
            startActivity(intent2)
        }

        boton3.setOnClickListener(){
            mostrarNombre(textoqueCambia.text.toString())
        }

        botonToast.setOnClickListener(){
            intent.putExtra("Texto",textoqueCambia.text.toString())
            startActivity(intent)
        }
        BotonRelative.setOnClickListener(){
            startActivity(intent2)
        }
        botonWeb.setOnClickListener(){
            val intent3:Intent = Intent(this,Webjeje::class.java)
            startActivity(intent3)
        }

    }

    fun showtoast(){
        Toast.makeText(this,"Hola inmundo" , Toast.LENGTH_SHORT).show()
    }

    fun mostrarNombre(Nombre:String){
        Toast.makeText(this, Nombre , Toast.LENGTH_SHORT).show()
    }

    fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = assets.open("paises(1).json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }


}