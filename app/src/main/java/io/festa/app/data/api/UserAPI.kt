package io.festa.app.data.api

import io.festa.app.data.entity.user.UserEntity
import io.reactivex.Flowable
import retrofit2.http.GET

interface UserAPI {

    @GET("/api/v1/user/me")
    fun getMe(): Flowable<UserEntity>
}