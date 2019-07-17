package io.festa.app.presentation.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import io.festa.app.R
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment() {

    interface OnInteractionListener {
        fun onGoogleLoginButtonClicked()

        fun onFacebookLoginButtonClicked()
    }

    companion object {
        fun newInstance(rootActivity: OnInteractionListener): LoginFragment {
            val fragment = LoginFragment()
            fragment.onInteractionListener = rootActivity
            return fragment
        }
    }

    private lateinit var onInteractionListener: OnInteractionListener

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGoogleButton()
        initFacebookButton()
    }

    private fun initGoogleButton() {
        googleLoginButton.setOnClickListener {
            onInteractionListener.onGoogleLoginButtonClicked()
        }
    }

    private fun initFacebookButton() {
        facebookLoginButton.setOnClickListener {
            onInteractionListener.onFacebookLoginButtonClicked()
        }
    }
}