package com.xizz.retrofit.di

import com.xizz.retrofit.ui.MainActivity
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: MainActivity)

}
