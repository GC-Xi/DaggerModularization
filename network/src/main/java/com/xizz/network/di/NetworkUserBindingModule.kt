package com.xizz.network.di

import com.xizz.network.HeroNetwork
import com.xizz.network.HeroNetworkImpl
import com.xizz.network.NetworkProvider
import com.xizz.network.NetworkProviderImpl
import dagger.Binds
import dagger.Module


@Module
interface NetworkUserBindingModule {
    @Binds
    fun heroNetwork(impl: HeroNetworkImpl): HeroNetwork

    @Binds
    fun networkProvider(impl: NetworkProviderImpl): NetworkProvider
}
