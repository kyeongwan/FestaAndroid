package io.festa.app.presentation.login

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import io.festa.app.R
import io.festa.app.base.FestaApplication
import kotlinx.android.synthetic.main.fragment_weblogin.*
import java.net.URL

class LoginWebFragment : Fragment() {


    interface OnInteractionListener {
        fun onCompleteLogin()
    }

    private lateinit var onInteractionListener: OnInteractionListener

    companion object {
        fun newInstance(rootActivity: OnInteractionListener): LoginWebFragment {
            val fragment = LoginWebFragment()
            fragment.onInteractionListener = rootActivity
            return fragment
        }
    }


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weblogin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        loginWebView.webChromeClient = WebChromeClient()

        loginWebView.settings.javaScriptEnabled = true
        loginWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        loginWebView.settings.userAgentString = System.getProperty("http.agent")

        loginWebView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, loadUrl: String?, favicon: Bitmap?) {
                super.onPageStarted(view, loadUrl, favicon)

                if (URL(loadUrl).host != "festa.io") {
                    return
                }

                val cookies = CookieManager.getInstance().getCookie(loadUrl)

//                saveCookieToPreference(cookies)
                FestaApplication.component.retrofits().updateCookieFromWebView()
                this@LoginWebFragment.onInteractionListener.onCompleteLogin()
            }
        }

        loginWebView.loadUrl("https://festa.io/api/login/google")
    }

//    private fun saveCookieToPreference(cookies: String?) {
//        if (activity != null) {
//            val sharedPreferences = activity.getSharedPreferences("Cookie", Context.MODE_PRIVATE)
//            sharedPreferences.edit {
//                putString("FESTA_SESSION", cookies)
//            }
//        }
//    }
}