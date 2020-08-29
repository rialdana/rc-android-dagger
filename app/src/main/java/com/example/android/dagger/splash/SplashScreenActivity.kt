package com.example.android.dagger.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    @Inject
    lateinit var splashScreenViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).appComponent.splashScreenComponent().create().inject(this)

        splashScreenViewModel.destination.observe(this, Observer { destination ->
            destination?.let {
                when (it) {
                    Destination.MAIN -> {
                        openActivity<MainActivity>()
                    }
                    Destination.REGISTRATION -> {
                        openActivity<RegistrationActivity>()
                    }
                    Destination.LOGIN -> {
                        openActivity<LoginActivity>()
                    }
                }
            }
        })

        setContentView(R.layout.activity_splash_screen)

    }

    private inline fun <reified T> openActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, T::class.java))
            finish()
        }, 1000)
    }
}