package io.festa.app.data.repository.source.user

import io.festa.app.data.api.Retrofits
import io.festa.app.data.api.UserAPI
import io.festa.app.data.entity.user.UserEntity
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSourceImpl @Inject constructor(private val retrofits: Retrofits) : UserRemoteDataSource {

    override fun getMe(): Flowable<UserEntity> {
        return retrofits.buildApi(UserAPI::class.java).getMe()
    }
}
