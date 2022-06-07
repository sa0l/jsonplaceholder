package com.jgc.myjsonplaceholder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jgc.myjsonplaceholder.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyJSONPlaceholder)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}