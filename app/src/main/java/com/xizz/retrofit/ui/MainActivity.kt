package com.xizz.retrofit.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import com.xizz.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.showHerosButton.setOnClickListener {
            startActivity(Intent(this, HerosActivity::class.java))
        }
    }
}

class DiffAdapterCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = (oldItem == newItem)

    @SuppressLint("DiffUtilEquals") // Fallback to Object.equals is necessary
    override fun areContentsTheSame(oldItem: T, newItem: T) = (oldItem == newItem)

    override fun getChangePayload(oldItem: T, newItem: T): Any? = null
}
