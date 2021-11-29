package com.example.relativelayout.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.relativelayout.R
import com.example.relativelayout.utils.calcularIdade
import com.example.relativelayout.utils.convertBase64ToBitmap

class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView
    lateinit var cvNovoPeso : CardView
    lateinit var cvHistorico : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

            tvNome = findViewById(R.id.tv_dash_nome)
            tvProfissao = findViewById(R.id.tv_dash_profissao)
            tvImc = findViewById(R.id.tv_dash_imc)
            tvNcd = findViewById(R.id.tv_dash_ncd)
            tvPeso = findViewById(R.id.tv_dash_peso)
            tvIdade = findViewById(R.id.tv_dash_idade)
            tvAltura = findViewById(R.id.tv_dash_altura)
            ivPerfil = findViewById(R.id.iv_dash_foto_perfil)
            cvNovoPeso = findViewById(R.id.cv_novo_peso)

            supportActionBar!!.hide()

            carregarDashboard()

            cvNovoPeso = findViewById(R.id.cv_novo_peso)

            cvNovoPeso.setOnClickListener {
                val pesagem = Intent(this, PesoActivity::class.java)
                startActivity(pesagem)
            }

    }

    private fun carregarDashboard() {
        val arquivo = getSharedPreferences(
            "usuario", MODE_PRIVATE
        )

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitmap)
    }

}
