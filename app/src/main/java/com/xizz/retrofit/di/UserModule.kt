package com.xizz.retrofit.di

import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Qualifier

@Qualifier
annotation class LoggedInUserID

@Module
class UserModule(
    private val userId: UUID
) {
    @Provides
    fun provideUserId(): UUID = userId
}
