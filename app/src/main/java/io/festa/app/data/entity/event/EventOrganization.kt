package io.festa.app.data.entity.event

import com.google.gson.annotations.SerializedName

data class EventOrganization(
    @SerializedName("organizationId") var organizationId: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null
)
