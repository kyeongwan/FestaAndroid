package io.festa.app.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.festa.app.domain.usecase.DefaultSubscriber
import io.festa.app.domain.usecase.GetUserUseCase
import io.festa.app.domain.user.User
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val userUseCase: GetUserUseCase) : ViewModel() {

    val user = MutableLiveData<User>()

    fun onButtonClick() {
        userUseCase.execute(object : DefaultSubscriber<User>() {
            override fun onNext(u: User?) {
                if (u != null) {
                    user.postValue(u)
                }
            }
        })
    }

    override fun onCleared() {
        userUseCase.dispose()
        super.onCleared()
    }

}