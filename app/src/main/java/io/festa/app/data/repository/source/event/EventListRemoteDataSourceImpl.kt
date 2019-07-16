package io.festa.app.data.repository.source.event

import io.festa.app.data.api.EventAPI
import io.festa.app.data.entity.event.EventEntity
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventListRemoteDataSourceImpl @Inject constructor(private val api: EventAPI) : EventListRemoteDataSource {

    override fun getEvents(): Flowable<List<EventEntity>> {
        return api.getEvents()
            .map { it.data }
    }
}
