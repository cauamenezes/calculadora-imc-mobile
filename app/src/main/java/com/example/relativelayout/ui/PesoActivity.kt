package com.example.relativelayout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.relativelayout.R
//import com.example.relativelayout.utils.getDataAtualBrasil
import java.time.LocalDate

class PesoActivity : AppCompatActivity() {

    lateinit var tvDataPesagem : TextView
    lateinit var etPeso : EditText
    lateinit var spinnerAtividade : Spinner
    lateinit var buttonRegistrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)

        tvDataPesagem = findViewById(R.id.tv_data_pesagem)
        etPeso = findViewById(R.id.et_peso)
        spinnerAtividade = findViewById(R.id.spinner_atividade)
        buttonRegistrar = findViewById(R.id.button_registrar)

        supportActionBar!!.hide()

        buttonRegistrar.setOnClickListener {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo. getString("data_pesagem", "")
            val nivel = arquivo.getString("nivel", "")
            
            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${etPeso.text.toString()}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nível", "$nivel;${spinnerAtividade.selectedItemPosition.toString()}")
            editor.apply()

            Toast.makeText(this, "Peso registrado com sucesso", Toast.LENGTH_SHORT)
            finish()
        }

    }
}