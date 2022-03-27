package com.xizz.retrofit

import android.app.Application
import com.xizz.retrofit.di.AppComponent
import com.xizz.retrofit.di.DaggerAppComponent

class MainApplication : Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
}
