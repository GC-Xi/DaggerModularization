package com.xizz.retrofit.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xizz.retrofit.databinding.ActivityHerosBinding
import com.xizz.retrofit.databinding.ViewholderHeroBinding
import com.xizz.retrofit.di.DaggerUserComponent
import com.xizz.retrofit.service.Hero
import com.xizz.retrofit.service.HeroService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HerosActivity : AppCompatActivity() {

    @Inject
    lateinit var service: HeroService

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerUserComponent.create().inject(this)

        super.onCreate(savedInstanceState)
        val viewBinding = ActivityHerosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val adapter = object : ListAdapter<Hero, HeroViewHolder>(DiffAdapterCallback<Hero>()) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
                HeroViewHolder(ViewholderHeroBinding.inflate(layoutInflater))

            override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
                val item = getItem(position)
                holder.viewBinding.heroName.text = item.name
            }
        }

        viewBinding.serviceIdText.text = service.toString()
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
