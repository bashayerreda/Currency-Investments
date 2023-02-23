package com.example.currencyinvestments

import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.data.remote.dto.CoinDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResults<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResults.Success(body)
        } else {
            NetworkResults.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        NetworkResults.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        NetworkResults.Exception(e)
    }
}
suspend fun <R,M>  handleResponse(request: suspend () -> Response<R>, mapResponse: (R) -> M) : Flow<M> {
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
                // TODO this should be fixed ASAP
                error(Error("not found"))

            }else{
                error(error(response.errorBody().toString()))
            }
        }
    }.flowOn(Dispatchers.IO)
}
