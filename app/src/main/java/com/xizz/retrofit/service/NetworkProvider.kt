package com.xizz.retrofit.service

import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkProvider {
    fun heroAPI(): SuperheroAPI
}

class NetworkProviderImpl : NetworkProvider {
    override fun heroAPI(): SuperheroAPI =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroAPI::class.java)
}
