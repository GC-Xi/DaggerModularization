package com.xizz.retrofit.di

import com.xizz.network.di.NetworkUserBindingModule
import com.xizz.retrofit.service.HeroService
import com.xizz.retrofit.service.HeroServiceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkUserBindingModule::class])
interface UserBindingModule {

    @Binds
    fun heroService(impl: HeroServiceImpl): HeroService
}
