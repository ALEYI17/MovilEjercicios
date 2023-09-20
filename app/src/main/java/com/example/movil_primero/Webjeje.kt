package com.example.movil_primero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Webjeje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webjeje)

        val web:WebView = findViewById(R.id.webe)
        web.webViewClient = WebViewClient()

        web.loadUrl("https://developer.android.com/develop/ui/views/components/spinner#:~:text=Spinners%20provide%20a%20quick%20way,can%20select%20a%20new%20one.")
    }
}