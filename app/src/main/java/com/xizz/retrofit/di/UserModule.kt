package com.xizz.retrofit.di

import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Qualifier

@Qualifier
annotation class LoggedInUserID

@Qualifier
annotation class RandomID

@Module
class UserModule(
    private val userId: UUID
) {
    @Provides
    @LoggedInUserID
    fun provideUserId(): UUID = userId


    @Provides
    @RandomID
    fun provideSomeId(): UUID = UUID.randomUUID()


}
