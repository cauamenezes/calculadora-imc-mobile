package com.example.relativelayout

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var et_data_nascimento: EditText
    lateinit var radio_button_feminino: RadioButton
    lateinit var radio_button_masculino: RadioButton
    lateinit var tv_sexo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById<EditText>(R.id.editEmail)
        editSenha = findViewById<EditText>(R.id.editSenha)
        editNome = findViewById<EditText>(R.id.editNome)
        editProfissao = findViewById<EditText>(R.id.editProfissao)
        editAltura = findViewById<EditText>(R.id.editAltura)
        et_data_nascimento = findViewById<EditText>(R.id.et_data_nascimento)
        radio_button_feminino = findViewById<RadioButton>(R.id.radio_button_feminino)
        radio_button_masculino = findViewById<RadioButton>(R.id.radio_button_masculino)
        tv_sexo = findViewById<TextView>(R.id.tv_sexo)

        supportActionBar!!.title = "Perfil"

        //Criar um calendário
        val calendario = Calendar.getInstance()

        //Determinar os dados (dia, mês e ano) do calendário
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        // Abrir o componente DatePicker
        val etDataNascimento = findViewById<EditText>(R.id.et_data_nascimento)

        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                    etDataNascimento.setText("$_dia/${_mes + 1}/$_ano")
                }, ano, mes, dia
            )

            dp.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_novo_usuario, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.menu.menu_novo_usuario) {
            Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
        }

        when (item.itemId) {
            R.id.menu_save -> {
                Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
            }

        }

        validarCampos()

        return true

    }

    fun validarCampos(): Boolean {

        if (editEmail.text.isEmpty()) {
            editEmail.error = "O e-mail é obrigatório"
            return false
        }

        if (editSenha.text.isEmpty()) {
            editSenha.error = "A senha é obrigatória"
            return false
        }

        if (editNome.text.isEmpty()) {
            editNome.error = "O nome é obrigatório"
            return false
        }

        if (editProfissao.text.isEmpty()) {
            editProfissao.error = "A profissão é obrigatória"
            return false
        }

        if (editAltura.text.isEmpty()) {
            editAltura.error = "A altura é obrigatória"
            return false
        }

        if (et_data_nascimento.text.isEmpty()) {
            et_data_nascimento.error = "A data de nascimento é obrigatória"
            return false
        }

        if (radio_button_feminino.isChecked || radio_button_masculino.isChecked) {
            tv_sexo.error = null
            return true
        } else {
            tv_sexo.error = "O sexo não foi definido"
            return false
        }

        return true

    }

}
