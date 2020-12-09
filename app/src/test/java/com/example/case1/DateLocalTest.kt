package com.example.case1

import com.example.case1.addition.convertDateToString
import com.example.case1.addition.convertToDate
import com.google.common.truth.Truth.assertThat
import org.junit.Test

private const val DAY = 30
private const val MONTH = 12
private const val YEAR = 2020
private const val EXPECTED_DATE = "2020-12-30"

class DateLocalTest {
    @Test
    fun date_correctFormat() {
        val date = convertToDate(YEAR, MONTH, DAY)
        assertThat(date.convertDateToString()).isEqualTo(EXPECTED_DATE)
    }
}
