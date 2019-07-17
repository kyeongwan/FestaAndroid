package io.festa.app.domain.user

import io.reactivex.Completable
import io.reactivex.Flowable

interface UserRepository {
    fun getRemoteMe(): Flowable<User>

    fun saveAuthCookie(cookie: String): Completable
}
