package com.xizz.retrofit.di

import com.xizz.models.PerUserScope
import com.xizz.retrofit.ui.HerosActivity
import dagger.Subcomponent

@PerUserScope
@Subcomponent(modules = [UserModule::class, UserBindingModule::class])
interface UserComponent {
    fun inject(activity: HerosActivity)
}
