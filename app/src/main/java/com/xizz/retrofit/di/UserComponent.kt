package com.xizz.retrofit.di

import com.xizz.retrofit.ui.HerosActivity
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerUserScope

@PerUserScope
@Subcomponent(modules = [UserModule::class, UserBindingModule::class])
interface UserComponent {
    fun inject(activity: HerosActivity)
}
