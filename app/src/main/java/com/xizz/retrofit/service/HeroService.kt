package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single

interface HeroService {
    fun getHeros(): Single<List<Hero>>
}

class HeroServiceImpl(
    private val heroNetwork: HeroNetwork,
) : HeroService {
    override fun getHeros(): Single<List<Hero>> = heroNetwork.getHeros()
}