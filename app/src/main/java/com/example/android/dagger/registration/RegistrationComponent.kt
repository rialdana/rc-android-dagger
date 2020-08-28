package com.example.android.dagger.registration

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope

// Creating a subcomponent to inherit the object graph from the parent component
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}