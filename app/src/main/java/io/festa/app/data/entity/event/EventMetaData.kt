package io.festa.app.data.entity.event

import com.google.gson.annotations.SerializedName

data class EventMetaData(
    @SerializedName("coverImage") var coverImage: String? = null,
    @SerializedName("contents") var contents: String? = null
)
