package com.example.saude_sem_fronteiras.data.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class RequestResult<out D, out E> {
    data class Success<D>(val value: D) : RequestResult<D, Nothing>()
    data class Failure<E>(val value: E) : RequestResult<Nothing, E>()

    inline fun handleResult(
        onSuccess: (result: D) -> Unit = {},
        onError: (error: E) -> Unit = {},
        onFinish: (D?) -> Unit = {}
    ): D? = when (this) {
        is Success -> {
            onSuccess(value)
            onFinish(value)
            value
        }
        is Failure -> {
            onError(value)
            onFinish(null)
            null
        }

    }

    inline fun <T> mapSuccess(transform: (D) -> T): RequestResult<T, E> = when (this) {
        is Success -> Success(transform(value))
        is Failure -> Failure(value)
    }

    inline fun <T> mapError(transform: (E) -> T): RequestResult<D, T> = when (this) {
        is Success -> Success(value)
        is Failure -> Failure(transform(value))
    }

    inline fun onSuccess(block: (D) -> Unit): RequestResult<D, E> {
        if (this is Success) block(value)
        return this
    }

    inline fun onError(block: (E) -> Unit): RequestResult<D, E> {
        if (this is Failure) block(value)
        return this
    }

    inline fun onFinish(block: (D?) -> Unit): RequestResult<D, E> {
        if (this is Success) block(value) else block(null)
        return this
    }

    inline fun <T, F> flatMap(
        transformSuccess: (D) -> RequestResult<T, F>,
        transformError: (E) -> RequestResult<T, F>
    ): RequestResult<T, F> = when (this) {
        is Success -> transformSuccess(value)
        is Failure -> transformError(value)
    }

    suspend fun <T, F> then(
        result: suspend (D) -> RequestResult<T, F>
    ): RequestResult<T, F> = when (this) {
        is Success -> result(this.value)
        is Failure -> Failure(value as F)
    }

    fun isSuccess() = (this is Success)

    fun isError() = (this is Failure)
}

fun <A, B, ERROR> combine(
    result1: RequestResult<A, ERROR>,
    result2: RequestResult<B, ERROR>
): RequestResult<Pair<A, B>, ERROR> {
    return when {
        result1.isError() -> RequestResult.Failure((result1 as RequestResult.Failure).value)
        result2.isError() -> RequestResult.Failure((result2 as RequestResult.Failure).value)
        else -> RequestResult.Success(
            Pair(
                (result1 as RequestResult.Success).value,
                (result2 as RequestResult.Success).value
            )
        )
    }
}

data class Error(val mensagem: String, val throwable: Throwable? = null)

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): RequestResult<T, Error> = withContext(dispatcher) {
    try {
        RequestResult.Success(apiCall())
    } catch (e: Exception) {
        RequestResult.Failure(Error(e.message ?: "Erro desconhecido", e))
    }
}
