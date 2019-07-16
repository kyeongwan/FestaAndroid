package io.festa.app.data.api

import io.festa.app.data.dto.EventListDTO
import io.festa.app.data.entity.event.EventEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventAPI {
    @GET("/api/v1/events")
    fun getEvents(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 5,
        @Query("order") order: String = "startDate"
    ): Flowable<EventListDTO>

    @GET("/v1/event/{eventId}")
    fun getEvent(@Path("eventId") eventId: Int): Flowable<EventEntity>
}
