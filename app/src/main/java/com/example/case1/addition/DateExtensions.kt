package com.example.case1.addition

import java.text.SimpleDateFormat
import java.util.*

fun convertToDate(year: Int, month: Int, day: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_YEAR, day)
    return calendar.time
}
fun Date.convertDateToString(): String {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(this)
}