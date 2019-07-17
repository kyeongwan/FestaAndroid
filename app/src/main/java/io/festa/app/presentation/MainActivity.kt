package io.festa.app.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.festa.app.R
import io.festa.app.di.scope.ActivityScope
import io.festa.app.domain.usecase.DefaultSubscriber
import io.festa.app.domain.usecase.GetEventListUseCase
import io.festa.app.domain.usecase.GetUserUseCase
import io.festa.app.domain.user.User
import io.festa.app.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@ActivityScope
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getEventListUseCase: GetEventListUseCase

    @Inject
    lateinit var getUserUseCase: GetUserUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))

        }

        button2.setOnClickListener {
            getUserUseCase.execute(object : DefaultSubscriber<User>() {
                override fun onNext(t: User?) {
                    super.onNext(t)

                    Log.e("Main", t.toString())
                }

                override fun onError(t: Throwable?) {
                    super.onError(t)

                    Log.e("Main", t.toString())
                }
            })
        }


    }
}
