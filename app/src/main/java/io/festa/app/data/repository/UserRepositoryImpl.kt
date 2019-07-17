package io.festa.app.data.repository

import io.festa.app.data.entity.user.UserEntityMapper
import io.festa.app.data.repository.source.user.UserRemoteDataSource
import io.festa.app.domain.user.User
import io.festa.app.domain.user.UserRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val userRemote: UserRemoteDataSource) :
    UserRepository {

    private val mapper = UserEntityMapper()

    override fun getRemoteMe(): Flowable<User> {
        return userRemote.getMe()
            .map { mapper.transform(it) }
    }

    override fun saveAuthCookie(cookie: String): Completable {
        return Completable.fromAction( { })
    }


}
