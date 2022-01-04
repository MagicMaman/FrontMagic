package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.BibronItem
import com.example.magicmamanapplication.data.SolideItem
import kotlinx.android.synthetic.main.bibron_item_layout.view.*
import kotlinx.android.synthetic.main.solide_item_layout.view.*

class MybibronAdapter : RecyclerView.Adapter<MybibronAdapter.MyViewHolder>(){

    private var myList = emptyList<BibronItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bibron_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeTimeBibron.text=myList[position].time
        holder.itemView.ResumeQuantity.text=myList[position].quantity
        holder.itemView.ResumeNotesBibron.text=myList[position].notes


    }

    fun setData(newList: List<BibronItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}