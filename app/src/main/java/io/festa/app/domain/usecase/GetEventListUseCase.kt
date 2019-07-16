package io.festa.app.domain.usecase

import io.festa.app.domain.event.EventList
import io.festa.app.domain.event.EventListService
import io.reactivex.Flowable
import javax.inject.Inject

class GetEventListUseCase @Inject constructor(private val service: EventListService) : UseCase<EventList, Void>() {

    override fun createFlowable(data: Void?): Flowable<EventList> = service.getEventList()
}
