package com.xizz.retrofit.di

import com.xizz.retrofit.ui.HerosActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: HerosActivity)

}
