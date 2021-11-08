package com.example.relativelayout.model

import java.time.LocalDate
import java.time.Year

data class Usuario (

    var id: Int,
    var nome: String,
    var email: String,
    var senha: String,
    var peso: Int,
    var altura: Double,
    var dataNascimento: LocalDate,
    var profissao: String,
    var sexo: Char,
    var fotoPerfil : String

        )