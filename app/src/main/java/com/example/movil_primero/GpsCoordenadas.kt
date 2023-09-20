    package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

    class GpsCoordenadas : AppCompatActivity() {
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps_coordenadas)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        var botonGps:ImageButton = findViewById(R.id.imageButton)
        val permissionsToRequest = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        botonGps.setOnClickListener(){
            var intentgps: Intent = Intent(baseContext,coordenadas::class.java)
            mFusedLocationClient.lastLocation.addOnSuccessListener (this){
                    location ->
                Log.i("LOCATION", "onSuccess location")
                if (location != null) {
                    Log.i("LOCATION", "Longitud: " + location.longitude)
                    intentgps.putExtra("locationLongitude",location.longitude.toString())
                    Log.i("LOCATION", "Latitud: " + location.latitude)
                    intentgps.putExtra("locationLatitude",location.latitude.toString())
                    intentgps.putExtra("locationElevation",location.altitude.toString())
                    startActivity(intentgps)
                }
            }

            startActivity(intentgps)
        }

        val permissionsNotGranted = permissionsToRequest.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        if (permissionsNotGranted.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                permissionsNotGranted.toTypedArray(),
                PermissionRequest.MULTIPLE_PERMISSIONS
            )
        }




    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionRequest.MULTIPLE_PERMISSIONS) {
            // Check if all requested permissions were granted
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                // Both permissions were granted, handle accordingly
            } else {

                Toast.makeText(
                    this,
                    "Access is required for certain features.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}