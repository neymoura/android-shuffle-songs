package dev.neymoura.android.songsprovider.model

import java.io.Serializable

open class Wrapper(
	open val wrapperType: String? = null,
	open val id: Int? = null
) : Serializable
