package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single

interface HeroNetwork {
    fun getHeros(): Single<List<Hero>>
}

class HeroNetworkImpl(
    private val networkProvider: NetworkProvider
): HeroNetwork {
    override fun getHeros(): Single<List<Hero>> = networkProvider.heroAPI().getHeroes()
}
