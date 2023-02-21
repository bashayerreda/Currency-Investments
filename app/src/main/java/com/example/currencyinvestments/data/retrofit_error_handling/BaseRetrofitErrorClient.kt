package com.example.currencyinvestments.data.retrofit_error_handling

import com.google.gson.Gson
import okhttp3.ResponseBody

class BaseRetrofitErrorClient : RetrofitErrorClient() {
    override fun parseError(errorBody: ResponseBody?): BaseError {
        return try{
            if (errorBody != null) {
                Gson().fromJson(errorBody.string(), BaseError::class.java)
            } else {
                BaseError("")
            }
        } catch (e: Exception){
            BaseError(e.localizedMessage.toString())
        }
    }
}