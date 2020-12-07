package com.example.case1.ui.main

import com.example.case1.addition.convertToDate
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


private const val DAY = 3
private const val MONTH = 0
private const val YEAR = 2020

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private var fromAndTo = convertToDate(YEAR, MONTH, DAY)

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun `getArticlesInfo Calls getAllArticles Method`() {
        viewModel.getArticlesInfo(fromAndTo, fromAndTo)
        val message = "MainViewModel newsList live data is empty"
        assertNotNull(message, viewModel.newsList)
    }
}