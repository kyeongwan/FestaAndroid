package io.festa.app.data.entity.event

import com.google.gson.annotations.SerializedName
import io.festa.app.domain.event.Event

data class EventEntity(
    @SerializedName("eventId") var eventId: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("startDate") var startDate: String? = null,
    @SerializedName("location") var location: EventLocation? = null,
    @SerializedName("metadata") var metadata: EventMetaData? = null,
    @SerializedName("hostOrganization") var hostOrganization: EventOrganization? = null
)

class EventEntityMapper {

    fun transform(entity: EventEntity): Event = Event(
        name = entity.name
    )
}
