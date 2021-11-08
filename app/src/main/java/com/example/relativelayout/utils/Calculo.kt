package com.example.relativelayout.utils

fun calcularImc(peso: Int, altura: Double) : Double {
    return peso / (altura * altura)
}