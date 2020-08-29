package com.example.android.dagger.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(private val userManager: UserManager) {

    private val _destination = MutableLiveData<Destination>()
    val destination: LiveData<Destination>
        get() = _destination

    init {
        validateDestination()
    }

    private fun validateDestination() {
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                _destination.value = Destination.REGISTRATION
            } else {
                _destination.value = Destination.LOGIN
            }
        } else {
            _destination.value = Destination.MAIN
        }
    }
}