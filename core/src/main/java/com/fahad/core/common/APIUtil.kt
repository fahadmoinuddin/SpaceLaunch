package com.fahad.core.common

import retrofit2.Response

/**
 * Utility object which contains functions to parse/transform retrofit response
 */
object APIUtil {
    fun <I, O> parseResponse(response: Response<I>, mapper: (I?) -> O): Resource<O> {
        return try {
            if (response.isSuccessful) {
                Resource.Success(mapper(response.body()))
            } else {
                Resource.Error(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage.orEmpty())
        }
    }
}
