package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

interface HeroService {
    val heroNetwork: HeroNetwork // for debugging
    fun getHeros(): Single<List<Hero>>
}

@Singleton
class HeroServiceImpl @Inject constructor(
    override val heroNetwork: HeroNetwork,
) : HeroService {
    override fun getHeros(): Single<List<Hero>> = heroNetwork.getHeros()
}
