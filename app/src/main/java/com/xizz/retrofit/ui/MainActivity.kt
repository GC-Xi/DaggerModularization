package com.xizz.retrofit.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import com.xizz.retrofit.MainApplication
import com.xizz.retrofit.databinding.ActivityMainBinding
import com.xizz.retrofit.di.ApplicationContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject @ApplicationContext
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MainApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.appText.text = appContext.toString() // Just for testing ApplicationContext
        viewBinding.showHerosButton.setOnClickListener {
            startActivity(Intent(this, HerosActivity::class.java))
        }
        viewBinding.switchUserButton.setOnClickListener {
            (application as MainApplication).switchUser()
        }
    }
}

class DiffAdapterCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = (oldItem == newItem)

    @SuppressLint("DiffUtilEquals") // Fallback to Object.equals is necessary
    override fun areContentsTheSame(oldItem: T, newItem: T) = (oldItem == newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? = null
}
