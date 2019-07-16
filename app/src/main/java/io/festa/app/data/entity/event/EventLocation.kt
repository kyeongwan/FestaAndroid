package io.festa.app.data.entity.event

import com.google.gson.annotations.SerializedName

data class EventLocation(
    @SerializedName("locationId") var locationId: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("latitude") var latitude: Double = 0.0,
    @SerializedName("longitude") var longitude: Double = 0.0
)
