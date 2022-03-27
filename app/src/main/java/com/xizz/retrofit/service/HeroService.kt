package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface HeroService {
    fun getHeros(): Single<List<Hero>>
}

class HeroServiceImpl @Inject constructor(
    private val heroNetwork: HeroNetwork,
) : HeroService {
    override fun getHeros(): Single<List<Hero>> = heroNetwork.getHeros()
}