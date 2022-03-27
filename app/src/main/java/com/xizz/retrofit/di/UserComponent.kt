package com.xizz.retrofit.di

import com.xizz.retrofit.model.PerUserScope
import com.xizz.retrofit.ui.HerosActivity
import dagger.Subcomponent

@PerUserScope
@Subcomponent(modules = [UserModule::class, UserBindingModule::class])
interface UserComponent {
    fun inject(activity: HerosActivity)
}
