package com.example.relativelayout.utils

import android.content.Context

fun autenticar(
    email: String,
    senha: String,
    context: Context
): Boolean {

    val arquivo = context.getSharedPreferences(
        "usuario", Context.MODE_PRIVATE
    )

    if (email == arquivo.getString("email", "")
        && senha == arquivo.getString("senha", "")) {
        return true
    } else {
        return false
    }
}