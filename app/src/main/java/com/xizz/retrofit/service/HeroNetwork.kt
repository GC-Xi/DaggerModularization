package com.xizz.retrofit.service

import com.xizz.retrofit.model.Hero
import com.xizz.retrofit.model.PerUserScope
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface HeroNetwork {
    val networkProvider: NetworkProvider // for debugging
    fun getHeros(): Single<List<Hero>>
}

@PerUserScope
class HeroNetworkImpl @Inject constructor(
    override val networkProvider: NetworkProvider
) : HeroNetwork {
    override fun getHeros(): Single<List<Hero>> = networkProvider.heroAPI().getHeroes()
}
