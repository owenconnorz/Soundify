package com.soundify.innertube.models.body

import com.soundify.innertube.models.Context
import com.soundify.innertube.models.Continuation
import kotlinx.serialization.Serializable

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?
)
