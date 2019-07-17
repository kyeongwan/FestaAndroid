package io.festa.app.domain.usecase

import io.festa.app.domain.user.UserService
import io.reactivex.Flowable
import javax.inject.Inject

class SaveAuthCookieUseCase @Inject constructor(private val service: UserService) :
    UseCase<Void, String>() {

    override fun createFlowable(data: String?): Flowable<Void> {
        if (data == null) {
            return Flowable.error(IllegalArgumentException("cookie is null"))
        }

        return service.saveAuthCookie(data).toFlowable()
    }
}
