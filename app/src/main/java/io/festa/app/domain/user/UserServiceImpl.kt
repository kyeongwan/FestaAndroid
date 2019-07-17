package io.festa.app.domain.user

import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val userRepository: UserRepository) :
    UserService {


    override fun getMe(): Flowable<User> {
        return userRepository.getRemoteMe()
    }

    override fun saveAuthCookie(cookie: String): Completable {
        return userRepository.saveAuthCookie(cookie)
    }
}