package com.example.hangeablerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var model: NumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(this).get(NumViewModel::class.java)

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()

        rcView.layoutManager = GridLayoutManager(this, 2)
        val myAdapter = MyAdapter(model)
        rcView.adapter = myAdapter
        model.liveData.observe(this,{
            myAdapter.refreshNums(it)
        })
    }

    override fun onResume() {
        super.onResume()
        model.updateList()
    }
}