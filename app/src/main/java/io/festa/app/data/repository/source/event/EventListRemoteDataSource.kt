package io.festa.app.data.repository.source.event

import io.festa.app.data.entity.event.EventEntity
import io.reactivex.Flowable

interface EventListRemoteDataSource {
    fun getEvents(): Flowable<List<EventEntity>>
}
