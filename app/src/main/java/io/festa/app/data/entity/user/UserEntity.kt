package io.festa.app.data.entity.user

import com.google.gson.annotations.SerializedName
import io.festa.app.domain.user.User

data class UserEntity(
    @SerializedName("firstName") var name: String? = null
)

class UserEntityMapper {

    fun transform(entity: UserEntity): User = User(
        name = entity.name
    )
}
