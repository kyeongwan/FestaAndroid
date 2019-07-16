package io.festa.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.festa.app.R
import io.festa.app.di.scope.ActivityScope
import io.festa.app.domain.event.EventList
import io.festa.app.domain.usecase.DefaultSubscriber
import io.festa.app.domain.usecase.GetEventListUseCase
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getEventListUseCase: GetEventListUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            getEventListUseCase.execute(object : DefaultSubscriber<EventList>() {
                override fun onNext(t: EventList?) {
                }

                override fun onError(t: Throwable?) {
                }

            })
        }


    }
}
