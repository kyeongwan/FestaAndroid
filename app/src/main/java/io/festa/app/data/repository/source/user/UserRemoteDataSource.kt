package io.festa.app.data.repository.source.user

import io.festa.app.data.entity.user.UserEntity
import io.reactivex.Flowable

interface UserRemoteDataSource {
    fun getMe(): Flowable<UserEntity>
}
