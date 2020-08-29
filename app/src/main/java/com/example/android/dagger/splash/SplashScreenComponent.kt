package com.example.android.dagger.splash

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SplashScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashScreenComponent
    }

    fun inject(activity: SplashScreenActivity)
}