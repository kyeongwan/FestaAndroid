package io.festa.app.domain.usecase

import io.festa.app.domain.user.User
import io.festa.app.domain.user.UserService
import io.reactivex.Flowable
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val service: UserService) : UseCase<User, Void>() {

    override fun createFlowable(data: Void?): Flowable<User> = service.getMe()
}
