package com.xizz.retrofit.service

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

data class Hero(
    var name: String,
    var realname: String,
    var team: String,
    var firstappearance: String,
    var createdby: String,
    var publisher: String,
    var imageurl: String,
    var bio: String
)

interface SuperheroAPI {
    @GET("marvel")
    fun getHeroes(): Single<List<Hero>>
}
