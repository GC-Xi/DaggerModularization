package com.xizz.retrofit.di

import com.xizz.retrofit.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun userComponent(module: UserModule): UserComponent

    fun inject(activity: MainActivity)
}
