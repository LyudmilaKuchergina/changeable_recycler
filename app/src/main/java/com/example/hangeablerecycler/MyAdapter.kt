package com.example.hangeablerecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val viewModel: NumViewModel
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var listNum: List<Int> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = listNum[position]
        holder.bind(num)
    }
    override fun getItemCount(): Int = listNum.size

    //передаем данные и оповещаем адаптер о необходимости обновления списка
    fun refreshNums(listNum: List<Int>) {
        this.listNum = listNum
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.twNumber)
        private val button = view.findViewById<Button>(R.id.butDelete)
        fun bind(numData: Int) {
            tvName.text = numData.toString()
            button.setOnClickListener {
                viewModel.delNumandUpdate(numData)
            }
        }
    }
}