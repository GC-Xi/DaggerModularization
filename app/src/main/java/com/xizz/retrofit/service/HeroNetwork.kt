package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface HeroNetwork {
    fun getHeros(): Single<List<Hero>>
}

class HeroNetworkImpl @Inject constructor(
    private val networkProvider: NetworkProvider
): HeroNetwork {
    override fun getHeros(): Single<List<Hero>> = networkProvider.heroAPI().getHeroes()
}
