package com.xizz.retrofit.service

import com.xizz.retrofit.model.Hero
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SuperheroAPI {
    @GET("marvel")
    fun getHeroes(): Single<List<Hero>>
}
