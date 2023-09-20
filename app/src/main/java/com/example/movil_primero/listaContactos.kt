package com.example.movil_primero
import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.movil_primero.AdapterContactos
import com.example.movil_primero.R

class listaContactos : AppCompatActivity() {
    private val PERMISSION_CONTACTS = 1
    private lateinit var mCursor: Cursor
    private lateinit var mContactsAdapter: AdapterContactos
    private lateinit var mlista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contactos)
        mlista = findViewById<ListView>(R.id.list)

        mContactsAdapter = AdapterContactos(this, null, 0)
        mlista.adapter = mContactsAdapter
        initView()
    }

    override fun onResume() {
        super.onResume()
        // Verificar y solicitar permisos cuando la actividad se reanuda
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSION_CONTACTS
            )
        } else {
            // Si ya se han otorgado los permisos, cargar los contactos
            initView()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_CONTACTS) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso otorgado, cargar los contactos
                initView()
            } else {
                // Permiso denegado, mostrar un mensaje
                Toast.makeText(
                    this,
                    "El acceso a los contactos es necesario para esta aplicación.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initView() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val mProjection = arrayOf(
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
            )
            val cursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                mProjection,
                null,
                null,
                null
            )

            if (cursor != null) {
                mContactsAdapter.changeCursor(cursor)
            } else {
                // Tratar el caso en que el cursor es nulo
                // Puedes mostrar un mensaje de error o realizar alguna otra acción aquí
            }
        }
    }

}
