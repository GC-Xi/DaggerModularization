package com.xizz.retrofit

import android.app.Application
import com.xizz.retrofit.di.AppComponent
import com.xizz.retrofit.di.DaggerAppComponent
import com.xizz.retrofit.di.UserComponent
import com.xizz.retrofit.di.UserModule
import java.util.*

class MainApplication : Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
    var userComponent: UserComponent = appComponent.userComponent(UserModule(UUID.randomUUID()))
}
