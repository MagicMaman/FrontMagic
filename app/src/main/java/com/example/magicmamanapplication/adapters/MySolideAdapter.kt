package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
import kotlinx.android.synthetic.main.new_item_layout.view.*
import kotlinx.android.synthetic.main.solide_item_layout.view.*

class MySolideAdapter: RecyclerView.Adapter<MySolideAdapter.MyViewHolder>(){

    private var myList = emptyList<SolideItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.solide_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeTimeDish.text=myList[position].time
        holder.itemView.ResumeDishName.text=myList[position].Name
        holder.itemView.ResumeNotesSolide.text=myList[position].notes


    }

    fun setData(newList: List<SolideItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}