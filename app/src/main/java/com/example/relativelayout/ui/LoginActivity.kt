package com.example.relativelayout.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.relativelayout.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvNovaConta = findViewById<TextView>(R.id.tv_nova_conta)

        tvNovaConta.setOnClickListener {
            val novaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(novaConta)
        }

    }
}