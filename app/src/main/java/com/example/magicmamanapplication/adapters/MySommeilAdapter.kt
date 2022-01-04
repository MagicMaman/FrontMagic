package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.SommeilItem
import kotlinx.android.synthetic.main.sommeil_item_layout.view.*

class MySommeilAdapter: RecyclerView.Adapter<MySommeilAdapter.MyViewHolder>(){

    private var myList = emptyList<SommeilItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sommeil_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeTimeSleep.text=myList[position].timesleep
        holder.itemView.ResumeAwake.text=myList[position].timeawake
        holder.itemView.ResumeNotesSommeil.text=myList[position].notes


    }

    fun setData(newList: List<SommeilItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}