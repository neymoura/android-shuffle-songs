package dev.neymoura.android.songsprovider.commons

import java.lang.Exception

class Resource<out T: Any?>(val data: T?, val error: Exception?) {
    var isSuccess = data != null && error == null
    var isFailure = data == null && error != null
    companion object {
        fun <T> success(successData: T): Resource<T> = Resource(data = successData, error = null)
        fun <T> failure(errorException: Exception?): Resource<T> = Resource(data = null, error =  errorException)
    }
}