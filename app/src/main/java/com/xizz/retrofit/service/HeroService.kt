package com.xizz.retrofit.service

import com.xizz.models.Hero
import com.xizz.models.PerUserScope
import com.xizz.network.HeroNetwork
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface HeroService {
    val heroNetwork: HeroNetwork // for debugging
    fun getHeros(): Single<List<Hero>>
}

@PerUserScope
class HeroServiceImpl @Inject constructor(
    override val heroNetwork: HeroNetwork,
) : HeroService {
    override fun getHeros(): Single<List<Hero>> = heroNetwork.getHeros()
}
