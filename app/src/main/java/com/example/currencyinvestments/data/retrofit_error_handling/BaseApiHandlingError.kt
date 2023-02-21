package com.example.currencyinvestments


import com.example.currencyinvestments.common.Constants
import com.example.currencyinvestments.data.retrofit_error_handling.BaseErrorIntr
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.Response

 interface BaseApiHandlingError  : BaseErrorIntr {
   suspend fun <R,M> ResponseHandler(request: suspend () -> Response<R>, mapResponse: (R) -> M) : Flow<M> {
    return flow {
        val response = request()
        if (response.isSuccessful){
            val returningData : M? = response.body()?.let { mapResponse(it) }
            returningData?.let {
                emit(it)
                return@flow
            }
        } else {
            if (response.code() == 404){

                error(NotFoundThrowable.NOT_FOUND_MESSAGE)
            }else{
                error(error(response.errorBody()))
            }
        }
    }.flowOn(Dispatchers.IO)
}



   private fun error(errorBody: ResponseBody?): String {
    return errorData.parseError(errorBody).message
  }



  }

  class NotFoundThrowable(message: String?) : Throwable(message){
       override fun getLocalizedMessage(): String? {
        return message
    }

      companion object{
          const val NOT_FOUND_MESSAGE = "NotFound"
      }
}