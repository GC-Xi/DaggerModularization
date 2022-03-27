package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

interface HeroNetwork {
    val networkProvider: NetworkProvider // for debugging
    fun getHeros(): Single<List<Hero>>
}

@Singleton
class HeroNetworkImpl @Inject constructor(
    override val networkProvider: NetworkProvider
) : HeroNetwork {
    override fun getHeros(): Single<List<Hero>> = networkProvider.heroAPI().getHeroes()
}
