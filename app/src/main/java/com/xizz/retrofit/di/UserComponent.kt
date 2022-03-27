package com.xizz.retrofit.di

import com.xizz.retrofit.ui.HerosActivity
import dagger.Subcomponent

@Subcomponent(modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: HerosActivity)

//    @LoggedInUserID
//    fun currentLoggedInUserId(): UUID
}
