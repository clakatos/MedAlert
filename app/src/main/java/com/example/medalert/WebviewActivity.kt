package com.example.medalert

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val searchText = intent.getStringExtra("SearchTerm")
        //Log.d("search", searchText)

        val webview : WebView = findViewById(R.id.webview)
        webview.settings.javaScriptEnabled
        webview.loadUrl("https://www.webmd.com/search/search_results/default.aspx?query=" + searchText)
    }
}