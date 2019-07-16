package io.festa.app.domain.event

import io.reactivex.Flowable

interface EventListService {

    fun getEventList(): Flowable<EventList>
}
