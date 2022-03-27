package com.xizz.retrofit.service

import com.xizz.retrofit.model.PerUserScope
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface NetworkProvider {
    fun heroAPI(): SuperheroAPI
}

@PerUserScope
class NetworkProviderImpl @Inject constructor() : NetworkProvider {
    override fun heroAPI(): SuperheroAPI =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroAPI::class.java)
}
