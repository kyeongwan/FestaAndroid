package io.festa.app.domain.user

import io.reactivex.Completable
import io.reactivex.Flowable

interface UserService {

    fun getMe(): Flowable<User>

    fun saveAuthCookie(cookie: String): Completable
}
