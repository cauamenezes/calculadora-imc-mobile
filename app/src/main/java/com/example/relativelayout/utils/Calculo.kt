package com.example.relativelayout.utils

import android.content.Context

fun calcularImc(context: Context) : Double {

    val arquivo =
        context.getSharedPreferences(
            "usuario", Context.MODE_PRIVATE)

    val pesos = arquivo.getString(
        "pesagem", "")!!.split(";").toTypedArray()

    val pesoAtual = pesos.last().toInt()

    val altura = arquivo.getFloat("altura", 0.0f)

    return (pesoAtual / (altura * altura)).toDouble()
}

fun calcularNcd() : Double {

    return 0.0
}