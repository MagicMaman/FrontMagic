package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.PoidsItem
import com.example.magicmamanapplication.data.SommeilItem
import kotlinx.android.synthetic.main.poids_item_layout.view.*
import kotlinx.android.synthetic.main.sommeil_item_layout.view.*
import kotlinx.android.synthetic.main.sommeil_item_layout.view.ResumeAwake

class MyPoidsAdapter: RecyclerView.Adapter<MyPoidsAdapter.MyViewHolder>(){

    private var myList = emptyList<PoidsItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.poids_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeDatePoids.text=myList[position].time
        holder.itemView.ResumeWeight.text=myList[position].poids
        holder.itemView.ResumeNotesPoids.text=myList[position].notes


    }

    fun setData(newList: List<PoidsItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}