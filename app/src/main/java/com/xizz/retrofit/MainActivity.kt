package com.xizz.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xizz.retrofit.databinding.ActivityMainBinding
import com.xizz.retrofit.databinding.ViewholderHeroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
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

        api.getHeroes().enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                adapter.submitList(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}

data class HeroViewHolder(val viewBinding: ViewholderHeroBinding) : RecyclerView.ViewHolder(viewBinding.root)

class DiffAdapterCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = (oldItem == newItem)

    @SuppressLint("DiffUtilEquals") // Fallback to Object.equals is necessary
    override fun areContentsTheSame(oldItem: T, newItem: T) = (oldItem == newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? = null
}