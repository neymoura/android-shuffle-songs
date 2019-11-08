package dev.neymoura.android.songsprovider.model

data class Track(
    val id: Int? = null,
    val wrapperType: String? = null,
    val artistId: Int? = null,
    val artistName: String? = null,
    val collectionId: Int? = null,
    val collectionName: String? = null,
    val trackName: String? = null,
    val trackCensoredName: String? = null,
    val trackExplicitness: String? = null,
    val trackTimeMillis: Int? = null,
    val primaryGenreName: String? = null,
    val country: String? = null,
    val releaseDate: String? = null,
    val artworkUrl: String? = null
)
