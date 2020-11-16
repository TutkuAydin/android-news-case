package com.example.case1.domain.usecases

interface BaseUseCase<R> {
    fun execute(from: String, to: String): List<R>
}
