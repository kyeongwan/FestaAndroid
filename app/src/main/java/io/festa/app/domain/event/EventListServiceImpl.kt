package io.festa.app.domain.event

import io.reactivex.Flowable
import javax.inject.Inject

class EventListServiceImpl @Inject constructor(private val eventListRepository: EventListRepository) :
    EventListService {

    override fun getEventList(): Flowable<EventList> {
        return eventListRepository.getRemoteEvents().map {
            EventList(newEvents = it)
        }
    }
}
