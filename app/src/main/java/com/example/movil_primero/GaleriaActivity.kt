package com.example.movil_primero

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class GaleriaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)

        if (checkGalleryPermission()) {
            // El permiso ya está concedido, puedes realizar acciones relacionadas con la galería aquí
            abrirGaleria()
        } else {
            // El permiso no está concedido, solicítalo al usuario
            requestGalleryPermission()
        }
    }

    private fun checkGalleryPermission(): Boolean {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestGalleryPermission() {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        ActivityCompat.requestPermissions(this, arrayOf(permission), PermissionRequest.GALERIA)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PermissionRequest.GALERIA) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, puedes realizar acciones relacionadas con la galería aquí

            } else {
                // Permiso denegado, toma medidas apropiadas (puede mostrar un mensaje al usuario)
            }
        }
    }

    private fun abrirGaleria() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PermissionRequest.GALERIA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PermissionRequest.GALERIA && resultCode == RESULT_OK && data != null) {
            val selectedImage = data.data
            var imageView2 = findViewById<ImageView>(R.id.imageView2)
            imageView2.setImageURI(selectedImage) // Establece la imagen en el ImageView
        }
    }
}