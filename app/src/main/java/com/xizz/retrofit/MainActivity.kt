package com.xizz.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xizz.retrofit.databinding.ActivityMainBinding
import com.xizz.retrofit.databinding.ViewholderHeroBinding
import com.xizz.retrofit.service.Hero
import com.xizz.retrofit.service.HeroNetworkImpl
import com.xizz.retrofit.service.HeroService
import com.xizz.retrofit.service.HeroServiceImpl
import com.xizz.retrofit.service.NetworkProviderImpl
import com.xizz.retrofit.service.SuperheroAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val service: HeroService = HeroServiceImpl(HeroNetworkImpl(NetworkProviderImpl()))
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(SuperheroAPI::class.java)

        val adapter = object : ListAdapter<Hero, HeroViewHolder>(DiffAdapterCallback<Hero>()) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
                HeroViewHolder(ViewholderHeroBinding.inflate(layoutInflater))

            override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
                val item = getItem(position)
                holder.viewBinding.heroName.text = item.name
            }
        }

        viewBinding.heroList.adapter = adapter

        service.getHeros()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.submitList(it)
            }, {}).addTo(compositeDisposable)
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }
}

data class HeroViewHolder(val viewBinding: ViewholderHeroBinding) : RecyclerView.ViewHolder(viewBinding.root)

class DiffAdapterCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = (oldItem == newItem)

    @SuppressLint("DiffUtilEquals") // Fallback to Object.equals is necessary
    override fun areContentsTheSame(oldItem: T, newItem: T) = (oldItem == newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? = null
}