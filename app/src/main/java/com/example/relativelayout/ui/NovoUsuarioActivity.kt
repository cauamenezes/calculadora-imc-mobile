package com.example.relativelayout.ui

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.example.relativelayout.R
import com.example.relativelayout.model.Usuario
import com.example.relativelayout.utils.convertStringToLocalDate
import java.time.LocalDate
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
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
        editDataNascimento = findViewById<EditText>(R.id.editDataNascimento)
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
        val etDataNascimento = findViewById<EditText>(R.id.editDataNascimento)

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

        if (validarCampos()) {
            //Criar o objeto usuario
            val dataNascimento = convertStringToLocalDate(editDataNascimento.text.toString())

            val usuario = Usuario(
                1,
                editNome.text.toString(),
                editEmail.text.toString(),
                editSenha.text.toString(),
                0,
                editAltura.text.toString().toDouble(),
                LocalDate.of(
                    dataNascimento.year,
                    dataNascimento.monthValue,
                    dataNascimento.dayOfMonth
                ),
                editProfissao.text.toString(),
                if (radio_button_feminino.isChecked){
                    'F'
                } else{
                    'M'
                }
            )

                //Salvar o registro
                //Em um SharedPreferences

                //A instrução abaixo irá criar um
                //Arquivo SharedPreferences se não existir
                // Se existir ele será aberto para edição
                val dados = getSharedPreferences (
                    "usuario", Context.MODE_PRIVATE)

            //vamos criar o objeto que permitirá a
            //edição dos dados do arquivo SharedPreferences
            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.senha)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()
        }

        Toast.makeText(this, "Usuário cadaastrado!", Toast.LENGTH_SHORT).show()


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

        if (editDataNascimento.text.isEmpty()) {
            editDataNascimento.error = "A data de nascimento é obrigatória"
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
