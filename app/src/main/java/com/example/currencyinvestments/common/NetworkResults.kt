package com.example.currencyinvestments.common

sealed class NetworkResults<T : Any> {
    class Success<T: Any>(val data: T) : NetworkResults<T>()
    class Error<T: Any>(val code: Int, val message: String?) : NetworkResults<T>()
    class Exception<T: Any>(val e: Throwable) : NetworkResults<T>()
}