package com.example.vkclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentAuth()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ContentAuth() {
    val loginUrl = "https://oauth.vk.com/authorize?client_id=51833964&redirect_uri=https%3A%2F%2Foauth.vk.com%2Fblank.html&display=mobile&"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(loginUrl)
            settings.javaScriptEnabled = true
        }
    }, update = {
        it.loadUrl(loginUrl)
    })
}
