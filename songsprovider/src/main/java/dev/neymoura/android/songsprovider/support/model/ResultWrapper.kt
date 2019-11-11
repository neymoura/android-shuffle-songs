package dev.neymoura.android.songsprovider.support.model

data class ResultWrapper<T>(
    val resultCount: Int? = null,
    val results: List<T>? = null
)
