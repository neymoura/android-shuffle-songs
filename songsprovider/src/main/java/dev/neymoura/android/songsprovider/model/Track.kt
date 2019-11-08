package dev.neymoura.android.songsprovider.model

data class Track(
    override val id: Int? = null,
    override val wrapperType: String? = null,
    val trackExplicitness: String? = null,
    val trackTimeMillis: Int? = null,
    val country: String? = null,
    val releaseDate: String? = null,
    val artworkUrl: String? = null,
    val artistId: Int? = null,
    val trackName: String? = null,
    val primaryGenreName: String? = null,
    val collectionName: String? = null,
    val trackCensoredName: String? = null,
    val artistName: String? = null,
    val collectionId: Int? = null
) : Wrapper()
