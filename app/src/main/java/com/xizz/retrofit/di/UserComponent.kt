package com.xizz.retrofit.di

import com.xizz.retrofit.ui.HerosActivity
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: HerosActivity)

}
