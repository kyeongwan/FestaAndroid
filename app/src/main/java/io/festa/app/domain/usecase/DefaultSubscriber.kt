package io.festa.app.domain.usecase

import io.reactivex.subscribers.DisposableSubscriber

open class DefaultSubscriber<T> : DisposableSubscriber<T>() {
    override fun onNext(t: T?) {}

    override fun onError(t: Throwable?) {}

    override fun onComplete() {}

}