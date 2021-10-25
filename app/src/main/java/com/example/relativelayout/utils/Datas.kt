package com.example.relativelayout.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun convertStringToLocalDate(brazilDate: String) : LocalDate {

    val dateFormaterFromBrazil = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate.
    parse(brazilDate, dateFormaterFromBrazil)

    return localDateFormat
}