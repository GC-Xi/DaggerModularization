package com.xizz.retrofit.di

import android.content.Context
import com.xizz.retrofit.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Qualifier
annotation class ApplicationContext

@Module
class AppModule(
    private val application: MainApplication
) {
    @Provides
    @ApplicationContext
    fun provideApplicationContext(): Context {
        return application
    }
}
