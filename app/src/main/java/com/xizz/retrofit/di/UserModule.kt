package com.xizz.retrofit.di

import com.xizz.retrofit.service.HeroNetwork
import com.xizz.retrofit.service.HeroNetworkImpl
import com.xizz.retrofit.service.HeroService
import com.xizz.retrofit.service.HeroServiceImpl
import com.xizz.retrofit.service.NetworkProvider
import com.xizz.retrofit.service.NetworkProviderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    @Binds
    abstract fun heroService(impl: HeroServiceImpl): HeroService

    @Binds
    abstract fun heroNetwork(impl: HeroNetworkImpl): HeroNetwork

    @Binds
    abstract fun networkProvider(impl: NetworkProviderImpl): NetworkProvider
}