package dev.neymoura.android.songsprovider.model

data class Artist(
	override val id: Int? = null,
	override val wrapperType: String? = null,
	val artistType: String? = null,
	val artistName: String? = null,
	val primaryGenreName: String? = null
) : Wrapper()
