package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.SommeilItem
import com.example.magicmamanapplication.data.TailleItem
import kotlinx.android.synthetic.main.sommeil_item_layout.view.*
import kotlinx.android.synthetic.main.taille_item_layout.view.*

class MyTailleAdapter: RecyclerView.Adapter<MyTailleAdapter.MyViewHolder>(){

    private var myList = emptyList<TailleItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.taille_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeDateTaille.text=myList[position].time
        holder.itemView.ResumeHeight.text=myList[position].taille
        holder.itemView.ResumeNotesTaille.text=myList[position].notes


    }

    fun setData(newList: List<TailleItem>){
        myList = newList
        notifyDataSetChanged()
    }
}