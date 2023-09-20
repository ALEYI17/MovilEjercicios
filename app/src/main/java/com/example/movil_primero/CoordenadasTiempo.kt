package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

class CoordenadasTiempo : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordenadas_tiempo)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        createLocationRequest()

        // Comprueba y solicita permisos en tiempo de ejecución si es necesario
        if (checkLocationPermission()) {
            requestLocationUpdates()
        }
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 15000 // Intervalo de actualización de 15 segundos
    }

    private fun requestLocationUpdates() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    locationResult.lastLocation?.let { location ->
                        // Aquí puedes acceder a las coordenadas de latitud y longitud en "location"
                        val latitude = location.latitude
                        Log.i("LOCATION", "Latitud: " + latitude)
                        val longitude = location.longitude
                        Log.i("LOCATION", "longitude: " + longitude)

                        // Haz lo que necesites con las coordenadas aquí
                    }
                }
            }

            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        } else {
            // El permiso no está concedido, solicítalo al usuario
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PermissionRequest.LOCATION
            )
        }
    }


    private fun checkLocationPermission(): Boolean {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PermissionRequest.LOCATION
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults) // Llama a super.onRequestPermissionsResult

        // Aquí puedes agregar tu lógica personalizada para manejar los resultados de los permisos
        if (requestCode == PermissionRequest.LOCATION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, puedes realizar acciones relacionadas con el permiso aquí
            } else {
                // Permiso denegado, puedes tomar medidas apropiadas en este caso
            }
        }
    }

}