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
interface UserBindingModule {

    @Binds
    fun heroService(impl: HeroServiceImpl): HeroService

    @Binds
    fun heroNetwork(impl: HeroNetworkImpl): HeroNetwork

    @Binds
    fun networkProvider(impl: NetworkProviderImpl): NetworkProvider
}
