package com.xizz.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SuperheroAPI {
    @GET("marvel")
    fun getHeroes(): Single<List<com.xizz.models.Hero>>
}
