package com.example.relativelayout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.relativelayout.R

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        supportActionBar!!.hide()
    }
}