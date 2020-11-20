package com.example.case1.domain.usecases

import java.util.*

interface BaseUseCase<R> {
    fun execute(from: Date, to: Date): List<R>
}
