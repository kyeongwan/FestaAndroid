package io.festa.app.domain.event

import io.reactivex.Flowable

interface EventListRepository {
    fun getRemoteEvents(): Flowable<List<Event>>
}
