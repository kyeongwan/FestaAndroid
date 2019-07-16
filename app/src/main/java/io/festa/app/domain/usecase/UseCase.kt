package io.festa.app.domain.usecase

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class UseCase<T, P> {

    private var disposable: Disposable? = Disposables.disposed()

    abstract fun createFlowable(data: P?): Flowable<T>

    fun execute(disposableObserver: DisposableSubscriber<T>) {
        execute(Function { t -> t }, disposableObserver)
    }

    fun <R> execute(map: Function<T, R>, disposableObserver: DisposableSubscriber<R>) {
        execute(null, map, disposableObserver)
    }

    fun execute(params: P, disposableObserver: DisposableSubscriber<T>) {
        this.execute(params, Function { t -> t }, disposableObserver)
    }

    fun <R> execute(data: P?, map: Function<T, R>, disposableObserver: DisposableSubscriber<R>) {
        dispose()

        disposable = createFlowable(data)
            .map(map::apply)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableObserver)
    }

    fun dispose() {
        if (disposable != null && !disposable!!.isDisposed()) {
            disposable!!.dispose()
        }
    }
}
