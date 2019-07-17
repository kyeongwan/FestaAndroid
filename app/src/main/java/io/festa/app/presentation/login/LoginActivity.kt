package io.festa.app.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.festa.app.R
import io.festa.app.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class LoginActivity : AppCompatActivity(), HasSupportFragmentInjector,
    LoginFragment.OnInteractionListener, LoginWebFragment.OnInteractionListener {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startLoginFragment()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return androidInjector
    }

    override fun onGoogleLoginButtonClicked() {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, LoginWebFragment.newInstance(this@LoginActivity))
        }
    }

    override fun onFacebookLoginButtonClicked() {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, LoginWebFragment.newInstance(this@LoginActivity))
        }
    }

    override fun onCompleteLogin() {
        finish()
    }

    private fun startLoginFragment() {
        supportFragmentManager.commit {
            addToBackStack(null)
            add(R.id.fragment_container, LoginFragment.newInstance(this@LoginActivity))
        }
    }


}