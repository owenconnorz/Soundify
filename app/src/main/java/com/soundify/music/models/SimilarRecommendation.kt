package com.soundify.music.models

import com.soundify.innertube.models.YTItem
import com.soundify.music.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
