package io.festa.app.data.dto

import com.google.gson.annotations.SerializedName
import io.festa.app.data.entity.event.EventEntity

data class EventListDTO(
    @SerializedName("page") var page: String? = null,
    @SerializedName("pageSize") var pageSize: String? = null,
    @SerializedName("total") var total: Int = 0,
    @SerializedName("rows") var data: List<EventEntity>? = emptyList()

)
