package io.festa.app.data.repository

import io.festa.app.data.entity.event.EventEntityMapper
import io.festa.app.data.repository.source.event.EventListRemoteDataSource
import io.festa.app.domain.event.Event
import io.festa.app.domain.event.EventListRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventListRepositoryImpl @Inject constructor(private val listRemote: EventListRemoteDataSource) :
    EventListRepository {

    private val mapper = EventEntityMapper()

    override fun getRemoteEvents(): Flowable<List<Event>> {
        return listRemote.getEvents()
            .concatMapIterable { it }
            .map { mapper.transform(it) }
            .toList().toFlowable()
    }
}
