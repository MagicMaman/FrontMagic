package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
import kotlinx.android.synthetic.main.new_item_layout.view.*

class MyteteAdapter : RecyclerView.Adapter<MyteteAdapter.MyViewHolder>(){

    private var myList = emptyList<teteItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeDuration.text=myList[position].time
        holder.itemView.ResumeNotesTete.text=myList[position].notes


    }

    fun setData(newList: List<teteItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }

}