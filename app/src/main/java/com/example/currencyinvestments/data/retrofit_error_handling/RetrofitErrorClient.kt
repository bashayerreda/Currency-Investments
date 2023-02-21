package com.example.currencyinvestments.data.retrofit_error_handling

import okhttp3.ResponseBody

abstract class RetrofitErrorClient {
    abstract fun parseError(errorBody: ResponseBody?) : BaseError
 }