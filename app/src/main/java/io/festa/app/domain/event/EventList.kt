package io.festa.app.domain.event

data class EventList(
    var newEvents: List<Event>? = emptyList()
)
