package dev.neymoura.android.songsprovider.model

import java.io.Serializable

class MusicalData(
	val id: Int? = null,
	val wrapperType: String? = null,
	val artistId: Int? = null,
	val artistType: String? = null,
	val artistName: String? = null,
	val trackExplicitness: String? = null,
	val trackTimeMillis: Int? = null,
	val country: String? = null,
	val releaseDate: String? = null,
	val artworkUrl: String? = null,
	val trackName: String? = null,
	val primaryGenreName: String? = null,
	val collectionName: String? = null,
	val trackCensoredName: String? = null,
	val collectionId: Int? = null
) : Serializable
